<template>
  <div class="time_panel">剩余<b>{{dd|num2}}</b>天<b>{{hh|num2}}</b>时<b>{{mm|num2}}</b>分<b>{{ss|num2}}</b>秒 </div>
</template>

<script>
module.exports = {
  props:["end"],
  data: function() {
    return {
      dd:0,
      hh:0,
      mm:0,
      ss:0
    }
  },
  mounted: function() {
    var self = this;
    setInterval(function () {
      time = self.GetRTime(self.end);
      self.dd = time[0];
      self.hh = time[1];
      self.mm = time[2];
      self.ss = time[3];
    },1000);
  },
  methods: {
    GetRTime:function (str){
       var EndTime= new Date(str); 
       var NowTime = new Date();
       var t =Math.max(0,EndTime.getTime() - NowTime.getTime());

       var d=Math.floor(t/1000/60/60/24);
       var h=Math.floor(t/1000/60/60%24);
       var m=Math.floor(t/1000/60%60);
       var s=Math.floor(t/1000%60);
       // console.log(d + "天",h + "时",m + "分",s + "秒");
       return [d,h,m,s];
    }
  }
}
</script>