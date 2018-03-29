<template>
  <van-uploader :after-read="onRead">
    <div class="fr">
      <i class='iconfont icon-add'></i>
    </div>
    <div class="bg"     :style="{backgroundImage: 'url(' + bg + ')'}"></div>
  </van-uploader>
</template>

<script>
module.exports = {
  props:[],
  data: function() {
    return {
      bg:""
    }
  },
  mounted: function() {
  },
  methods: {
    onRead:function (f) {
      var self = this;
      get("/upload", {} )
      .then(
          function (res) {
            self.bg = res.url;
            self.$emit("success",res.url);
          }
      )
    }
  }
}
</script>
