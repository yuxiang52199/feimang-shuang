<template>
  <div class="du_user  " >

    <a :href=" 'my.html?id='+ my.uid " class="head">  
        <div class="user_ico">
          <div class="pic"><img :src="my.src"></div>
          <h2 class="name">{{my.name}}</h2>
        </div>
        <i class='iconfont icon-xiaojiantou'></i>
    </a>
    <div class="cont">
      <div class="item">
        <h2>{{my.days}}天</h2>
        <h3>坚持阅读</h3>
      </div>
      <div class="item">
        <h2>{{my.num_book}}本</h2>
        <h3>共计读书</h3>
      </div>
    </div>

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
