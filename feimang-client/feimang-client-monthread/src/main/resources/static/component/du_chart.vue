<template>
  <div id="chart"></div>
</template>

<script>
var option = {
    radar: {
        shape: 'circle',
        name: {
           textStyle: {
               color: '#fff',
               backgroundColor: '#299',
               borderRadius: 3,
               fontSize: "110%",
               padding: [6,6]
          }
        },
        indicator: [
           { name: '历史', max: 100},
           { name: '文化', max: 100},
           { name: '哲学', max: 100},
           { name: '认知', max: 100},
           { name: '科学', max: 100},
           { name: '文学', max: 100},
           { name: '艺术', max: 100},
           { name: '经管', max: 100},
           { name: '励志', max: 100},
           { name: '休闲', max: 100}
        ],
        radius: "60%"
    },
    series: [{
        name: '',
        type: 'radar',
        tooltip: {
            trigger: 'item'
        },
        areaStyle: {normal: {
          color : "rgba(100,0,0,0.2)"
        }},
        lineStyle: {normal: {
          color : "rgba(100,0,0,0.4)"
        }},
        data : [
            {
                value : [],
                label: {  
                    normal: {  
                        show: true,  
                        color: '#900',
                        formatter:function(params) {  
                            return params.value;  
                        }  
                    }  
                } 
            }
        ]
    }]
};



module.exports = {
  props:["data","type"],
  data: function() {
    return {
      
    }
  },
  mounted: function() {
    

    
  },
  methods: {
    init:function (ddd) {
      var arr=[];
      for (var i = 0; i < ddd.length; i++) {
        arr.push(ddd[i].val);
      }
      option.series[0].data[0].value = arr;
      var myChart = echarts.init(document.getElementById('chart'));
      myChart.setOption(option);
    }
  }
}
</script>
