<template>
  <div class="du_rate">
    <i class='iconfont icon-xiaoxingxing'></i>
    <i class='iconfont icon-xiaoxingxing'></i>
    <i class='iconfont icon-xiaoxingxing'></i>
    <i class='iconfont icon-xiaoxingxing'></i>
    <i class='iconfont icon-xiaoxingxing'></i>
  </div>
</template>

<script>
module.exports = {
  props:["rank"],
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
    setTimeout(
      function(){
        self.posi.tit = "很长很长的一个地名";
        self.$emit("success",self.posi);
      },500);
  },
  methods: {
    
  }
}
</script>