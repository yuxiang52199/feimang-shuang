var NODE_ENV = "api"; //api是服务器实测环境，easy是mock环境
/*var api_server = axios.create({
  baseURL: 'https://easy-mock.com/mock/5a29537670188c51fc72df8f/irh',
  timeout: 5000,
});*/
var ROOT = '';
/*var ROOT = 'http://m.test.cn-onsite.com/api/';*/


if(NODE_ENV == "api"){
    var api_server = axios.create({
      baseURL: ROOT,
      timeout: 5000,
    });
    var my_token = window.localStorage.getItem("jsd_token") || "";
    api_server.defaults.headers = {
        token: my_token,
        post:{
            'Content-Type':'application/json;charset=UTF-8'
        }
    };
}

//请求拦截器
api_server.interceptors.request.use(function (config) {
    if (config.method == 'post') {
        config.data = JSON.stringify(config.data)
        console.log('请求地址' + config.url, '请求参数', JSON.parse(config.data))
    }
    return config
}, function (error) {
    console.log("错误的传参")
    return Promise.reject(error)
})

//响应拦截器
api_server.interceptors.response.use(function (res) {
    switch(res.data.resultCode)
    {
    case "401":
      return Promise.reject(res.data.message);
      break;
    case "403":
      vue = new Vue();
      vue.$dialog.toast({
        mes: "这个操作不能完成，因为没有权限",
        icon: 'error',
        timeout: 2000,
        callback: function () {}
      });
      break;
    case "404":
      vue = new Vue();
      vue.$dialog.toast({
        mes: "资源未找到，3秒后将跳转到首页",
        icon: 'error',
        timeout: 2000,
        callback: function () {
          window.location.href= "index.html"
        }
      });
      break;
    case "400":
        vue = new Vue();
        vue.$dialog.toast({
          mes: "您没有访问权限，请重新登录",
          icon: 'error',
          timeout: 2000,
          callback: function () {
            // window.location.href= "login.html"
          }
        });
      break;
    default:
      return res.data;
    }
  
}, function (error) {
    if (error.message.indexOf('timeout') >= 0) {
        return Promise.reject('请求超时')
    }
    else if (error.message.indexOf('Network Error') >= 0) {
        return Promise.reject('网络连接错误')
    }
    else if (error.message.indexOf('404') >= 0) {
        console.log('未找到相应接口');
        // return Promise.resolve(true);
    }
    // return Promise.reject('网络不明问题')
});

// 隐藏loading
function hide_load() {
    if(document.querySelector("#loading")){
        document.querySelector("#loading").style.display="none";
    }
}
get = function (url, para) {
    return new Promise(function (resolve, reject) {
        api_server.get( url , {params: para })
            .then(function (res) {
                hide_load();
                resolve(res);
            }, function (err) {
                hide_load();
                reject(err);
            })
            .catch(function (error) {
                reject(error)
            })
    })
};

post = function (url, params) {
    return new Promise(function (resolve, reject) {
        api_server.post(url, params)
            .then(function (response) {
                hide_load();
                resolve(response);
            }, function (err) {
                hide_load();
                reject(err);
            })
            .catch(function (error) {
                reject(error)
            })
        
    })
}

