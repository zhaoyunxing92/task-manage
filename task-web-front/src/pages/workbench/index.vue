<template>
  <div>
    <Col span="4">
    <Card>
      <p slot="title">
        <Icon type="android-desktop"></Icon> &nbsp;我的工作台
      </p>
      <a href="#" slot="extra" @click.prevent="changeLimit">
        <Icon slot="extra" type="ios-skipbackward" size="20"></Icon>
      </a>

      <Menu :active-name="$route.name" width="auto" @on-select="goToPath">
        <MenuItem :name="menu.name" v-for="(menu,index) in $store.state.workbenchMenu" :key="index">
          <Icon :type="menu.icon"></Icon>
          {{menu.menuName}}
        </MenuItem>
      </Menu>
    </Card>

    </Col>
    <Col span="20">
    <Card>
      <p slot="title">
        <Icon :type="$route.meta.icon"></Icon>
        &nbsp;{{$route.meta.menuName}}&nbsp;
      </p>
      <a href="#" slot="extra" @click.prevent="changeLimit">
        <Icon type="refresh"></Icon>
        刷新
      </a>
      <router-view/>
    </Card>

    </Col>
  </div>

</template>
<script>
  export default {
    name: "task-workbench",
    data () {//数据
      return {
        //currentSelectCardName: this.$route.meta.menuName
      }
    },
    created(){
      //console.log(this.$store.state.workbenchMenu)
    },
    mounted(){
      //el 被新创建的 vm.$el 替换，并挂载到实例上去之后调用该钩子。如果 root 实例挂载了一个文档内元素，当 mounted 被调用时 vm.$el 也在文档内。
    },
    methods: {
      //跳转
      goToPath(key){
        this.$router.push({name: key});
      }
    }

  }
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
