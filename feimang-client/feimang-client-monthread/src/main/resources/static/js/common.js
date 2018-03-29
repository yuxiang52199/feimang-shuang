Vue.use(httpVueLoader);
// 过滤器，显示出2位数字
Vue.filter('num2', function(num) {  
  var tt = (num<10)?("0"+num):num;
  return tt;
})

// 过滤器，限止10个字
Vue.filter('substr', function(str) {  
  var tt = (str.length>10)?"..":"";
  var v = str.substring(0,10) + tt;
  return v;
})

// 时间转换1--输出“早上 07:22”
Vue.filter('ctime1', function(str) {  
  moment.locale("zh-cn");
  var v = moment(new Date(str)).format("a HH:mm");
  return v;
})

// 时间转换2--输出“2018-11-22”
Vue.filter('ctime2', function(str) {  
  moment.locale("zh-cn");
  var v = moment(new Date(str)).format("YYYY-MM-DD");
  return v;
})

// 获取当前文件名前缀
function getJsonName()
{
    var str = window.location.pathname;
    var name = str.split("/").pop().split(".")[0];
    return 'data/' + name+'.json';
}


// 获取路径参数
function getQS(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}


var mixin_common = {
    data:{
    }, 
    mounted: function() {
    },
    /*watch:{
      loading:function(curVal,oldVal){}
    },*/
    computed: {
    },

    methods: {
      navH:function(flag) {
        this.nav_show = flag;
      }
    }
    
};
