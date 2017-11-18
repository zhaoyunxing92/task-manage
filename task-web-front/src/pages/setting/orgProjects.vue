<template>

         <div>
           <Spin size="large" fix v-if="showSpin"></Spin>

           <Card style="width: 20%;margin: 20px;display: inline-block" v-for="project in projects" :key="project.uid">
             <p slot="title" class="layout-orgs-title">{{project.name}}</p>
             <a href="#" slot="extra" v-if="project.isAdmin">
               <Icon type="gear-b" size="25"></Icon>
             </a>


           </Card>


         </div>
</template>
<script>
  export default {
    name: "task-setting-projects",
    data () {//数据
      return {
        showSpin:true,
        projects:[],
      }
    },

    methods: {
       getOrgProjects(){
        let that=this;

         setTimeout(() => {
           that.projects=[{name:'test',uid:'1'},{name:'test',uid:'2'},{name:'test',uid:'3'},{name:'test',uid:'4'},{name:'test',uid:'5'},{name:'test',uid:'6'}]
           that.showSpin=false;
         }, 2000);

       }
    },
    created(){
      this.getOrgProjects();
    },
  }
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .demo-spin-icon-load{
    animation: ani-demo-spin 1s linear infinite;
  }
  @keyframes ani-demo-spin {
    from { transform: rotate(0deg);}
    50%  { transform: rotate(180deg);}
    to   { transform: rotate(360deg);}
  }
  .demo-spin-col{
    height: 100px;
    position: relative;
    border: 1px solid #eee;
  }
</style>
