<template>
  <a href="address.html" class="du_geo">
    <i class='iconfont icon-dingwei'></i>
    <h2>{{posi.tit}}</h2>
    <i class='iconfont icon-xialajiantou'></i>
  </a>
</template>

<script>
module.exports = {
  props:[],
  data: function() {
    return {
      posi: {
        tit: '',
        lng:null,
        lat:null
      }
    }
  },
  mounted: function() {
    var self = this;
    this.init().then(
        function (res) {
          console.log("当前位置：",res);
          self.posi = res;
          self.$emit("success",res)
        },
        function (err) {
          console.log("定位失败：",err);
          self.posi = err;
          self.$emit("fail",err)
        }
    )
    /*setTimeout(
      function(){
        self.posi.tit = "很长很长的一个地名";
        self.$emit("success",self.posi);
      },500);*/
  },
  methods: {
    init:function() {
          var self = this;
          return new Promise(function (resolve, reject) {
              AMap.service(['AMap.Geolocation'], function() { 
                geolocation = new AMap.Geolocation({
                        timeout: 10000,
                        convert: true,
                        zoomToAccuracy:true
                    });
                AMap.event.addListener(geolocation, 'complete', function (res) {
                    var rposi = {
                          tit:res.pois+res.addressComponent.township+res.addressComponent.street+res.addressComponent.streetNumber,
                          lng:res.position.lng,
                          lat:res.position.lat,
                      };
                    resolve(rposi);
                });
                AMap.event.addListener(geolocation, 'error', function (err) {
                    self.$dialog.confirm({
                      title: '',
                      message: '自动定位失败，是否转手工定位页？',
                      cancelButtonText: '停留在本页',
                      confirmButtonText: '转手工定位',
                    }).then(() => {
                      window.location.href="address.html";
                    }).catch(() => {
                      console.log('取消');
                    });

                    var rposi = {
                        tit:"自动定位失败",
                        lng:0,
                        lat:0,
                    };
                    reject(rposi);
                }); 

                geolocation.getCurrentPosition();
              });
              
          });

          
    }
  }
}
</script>