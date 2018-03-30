<template>
  <div class="du_book">
    <!-- 锁定 0-->
    <div v-if="data.status==0">  
        <div class="pic book_bg" @click="$toast('在您收到月读包之前，不给偷看哦~');"></div>
        <div class="cont">
          <h2>{{data.lock_desc}}</h2>
        </div>
    </div>
    
    <!-- 确认计划但未收货，只有图和简文 1-->
    <div v-if="data.status==1">  
        <div class="pic book_bg" @click="$toast('在您收到月读包之前，不给偷看哦~');"></div>
        <div class="cont">
          <h2>{{data.lock_desc}}</h2>
        </div>
    </div>

    <!-- 开始阅读 2-->
    <div v-if="data.status==2">  
        <a class="pic" :href=" 'detail.html?id='+ data.book_id "><img :src="data.src"></a>
        <div class="cont">
          <div>
            <a :href=" 'detail.html?id='+ data.book_id "><h2 class="name">{{data.book_name}}</h2></a>
            <div class="jcsb">
              <h3>{{data.author}}</h3>
              <h3>未读</h3>
            </div>
            <div class="h30"></div>
            <div class="jcsb">
              <span class="btn" @click="$emit('start',data.book_id)">开始阅读</span>
            </div>
          </div>

          
        </div>
    </div>

    <!-- 阅读中 2-->
    <div  v-if="data.status==3">  
        <a class="pic" :href=" 'detail.html?id='+ data.book_id "><img :src="data.src"></a>
        <div class="cont">
          <div>
            <a :href=" 'detail.html?id='+ data.book_id "><h2 class="name">{{data.book_name}}</h2></a>
            <div class="jcsb">
              <h3>{{data.author}}</h3>
              <h3 class="green">正在阅读</h3>
            </div>
            <div class="h30"></div>
            <div class="jcsb">
              <span class="btn" @click="$emit('complete',data)">读完</span>
              <a class="btn" :href=" 'uploadPad.html?id=' + data.book_id ">发布书拍</a>
            </div>
          </div>
        </div>
    </div>

    <!-- 完成 3-->
    <div  v-if="data.status==4">  
        <a class="pic" :href=" 'detail.html?id='+ data.book_id "><img :src="data.src"></a>
        <div class="cont">
          <div>
            <a :href=" 'detail.html?id='+ data.book_id "><h2 class="name">{{data.book_name}}</h2></a>
            <div class="jcsb">
              <h3>{{data.author}}</h3>
              <h3>已读完</h3>
            </div>
          </div>
        </div>
    </div>

  </div>
</template>

<script>
module.exports = {
  props:["data"],
  data: function() {
    return {}
  },
  mounted: function() {
  },
  methods: {
    status_txt:function (n) {
      if(n==0){return "锁定"};
      if(n==1){return "等送货"};
      if(n==2){return "未读"};
      if(n==3){return "正在阅读"};
      if(n==4){return "已读完"};
    }
  }
}
</script>
