<template>
  <div class="du_user_mini" >

    <a :href=" 'my.html?id='+ my.uid " class="head">  
        <div class="user_ico">
          <div class="pic"><img v-lazy="my.src||'images/user.png'"></div>
          <h2 class="name">{{my.name}}</h2>
        </div>
        <i class='iconfont icon-qianjin'></i>
    </a>
  </div>
</template>

<script>
module.exports = {
  props:["data"],
  data: function() {
    return {
      my:{}
    }
  },
  mounted: function() {
    var self = this;
    get("/user", {} )
    .then(
        function (res) {
          self.my = res;
        },
        function (err) {
          console.log(err);
        }
    )
  },
  methods: {
    
  }
}
</script>
