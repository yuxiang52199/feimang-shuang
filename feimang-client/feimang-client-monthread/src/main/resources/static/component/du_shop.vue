<template>
  <div class="du_shop">
    
    <template v-if="data.sid">
      <a class="thum" :href=" 'shop.html?id='+data.sid ">  
          <img v-lazy="data.thum">
      </a>
      <div class="cont">
          <a class="tit" :href=" 'shop.html?id='+data.sid "> {{data.tit}} </a>
          <div class="tit_sub">
               <b :class="{'zs':data.tit_zs}">{{data.tit_sub}}</b>
               <h3>{{data.shop_txt}}</h3>
          </div>
          <div class="month_sales">
            <du_rate :rank="data.rank"></du_rate>| 月售{{data.month_sales}}单
          </div>
          <div class="transit">{{data.transit}}</div>
          <div class="dis" v-if="data.dis">{{data.dis}}</div>
      </div>
    </template>
    <div class="loading" v-if="!data.sid">
      <van-loading color="black" />
    </div>
   
  </div>
</template>

<script>
module.exports = {
  props:["data"],
  components: {
    'du_rate': 'url:component/du_rate.vue'
  },
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