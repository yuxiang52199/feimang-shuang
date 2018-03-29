<template>
  <ul class="du_btn_list">
    <li v-for="item,index in data" :class=" 'bgc'+(index+1) ">
      {{item.name}}+{{item.val}}
    </li>
  </ul>
</template>

<script>
module.exports = {
  props:["data","pre"],
  data: function() {
    return {
      
    }
  },
  mounted: function() {
    console.log(this.data);
  },
  methods: {
    
  }
}
</script>
