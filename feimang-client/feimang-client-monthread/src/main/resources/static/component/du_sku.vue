<template>
  <div class="du_sku">

    <a :href=" 'shop.html?id='+ data.sid ">  
        <img v-lazy="data.src">
        <h2 class="tit">{{data.tit}}</h2>
        <div class="price_cont">
          <h3 class="price">¥{{data.price}}</h3>
          <h3 class="price_ori">¥{{data.price_ori}}</h3>
        </div>
        <i class='iconfont icon-hot'></i>
    </a>

    <div class="loading" v-if="!data.sid">
      <van-loading color="black" />
    </div>
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