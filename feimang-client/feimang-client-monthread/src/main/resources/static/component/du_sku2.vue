<template>
  <div class="du_sku2">
    <a :href=" 'shop.html?id='+ data.sid ">  
        <img v-lazy="data.src">
        <h2 class="tit">{{data.tit}}</h2>
    </a>

    <div class="price_cont">
      <h3 class="price_ori">¥{{data.price_ori}}</h3>
      <h3 class="price"><sub>¥</sub>{{data.price}}</h3>
    </div>
    <i class='iconfont icon-gouwuche1 cart'></i>
    
  </div>
</template>

<script>
module.exports = {
  props:["data"],
  data: function() {
    return {
    }
  },
  mounted: function() {
  },
  methods: {
    
  }
}
</script>