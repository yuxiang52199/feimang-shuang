<template>
  <section 
    class='expand' @click="clickH">
    <slot name="prev"></slot>
    <span>{{ active? txt : arr }}</span>
    <i class='iconfont icon-open' v-if="(!active)&& ishow"></i>
    <i class='iconfont icon-shouqi' v-if="active&& ishow"></i>
    <slot name="next"></slot>
  </section>
</template>

<script>
module.exports = {
  props:{
    words: {type: [Number], default: 60 },  //限制字数
    ico_show: {type: [Boolean], default: true},   //显示默认上下箭头
    lock: {type: [Boolean], default: false},   //锁死伸缩
    txt: {type: [String], default: "无内容..."}   //内容
  },
  data: function() {
    return {
      active:false,
      ishow:this.ico_show
    }
  },
  mounted: function() {
    
  },
  computed: {
    arr: function () {
      // 如果“全文字数”小于“欲截取字数”，则不做处理
      if(this.txt.length < this.words){
        this.ishow = false;
        return this.txt;
      }
      return this.txt.substring(0,this.words)+"...";
    }
  },
  methods: {
    clickH:function(){
        if(this.lock){return false;}
        this.active = !this.active;
    }
  }
}
</script>