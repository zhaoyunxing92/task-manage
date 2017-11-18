<template>
  <div class="layout-main">
    <div class="layout-main-head">

      <Menu mode="horizontal" :active-name="$route.name" @on-select="goToPath" class="layout-main-head">
        <MenuItem :name="appMenu.name" :class="appMenu.right ? 'menu-item-right':'' "
                  v-for="(appMenu,index) in $store.state.orgMenuList" :key="index">
          <Icon :type="appMenu.icon" :color="appMenu.iconColor"></Icon>
          {{appMenu.menuName}}
        </MenuItem>
      </Menu>
    </div>

    <div class="layout-main-content">
      <router-view/>
    </div>
  </div>
</template>
<script>
  export default {
    name: "task-main",
    data () {//数据
      return {}
    },
    computed: {
      //计算属性将被混入到 Vue 实例中。所有 getter 和 setter 的 this 上下文自动地绑定为 Vue 实例。计算属性的结果会被缓存，除非依赖的响应式属性变化才会重新计算。注意，如果实例范畴之外的依赖 (比如非响应式的 not reactive) 是不会触发计算属性更新的。
    },
    methods: {
      // 路由跳转
      goToPath(key){
        this.$router.push({name: key});
      }
    },
    watch: {
      //一个对象，键是需要观察的表达式，值是对应回调函数。值也可以是方法名，或者包含选项的对象。Vue 实例将会在实例化时调用$watch()，遍历 watch 对象的每一个属性。
    },
    beforeCreate(){
      //在实例初始化之后，数据观测(data observer) 和 event/watcher 事件配置之前被调用
    },
    created(){
      //实例已经创建完成之后被调用。在这一步，实例已完成以下的配置：数据观测(data observer)，属性和方法的运算，watch/event 事件回调。然而，挂载阶段还没开始，$el 属性目前不可见
    },
    mounted(){
      //el 被新创建的 vm.$el 替换，并挂载到实例上去之后调用该钩子。如果 root 实例挂载了一个文档内元素，当 mounted 被调用时 vm.$el 也在文档内。
    },
  }
</script>

<style type="text/less" lang="less">
  .layout-main {
    .layout-main-head {
      height: 45px;
      line-height: 45px;
      padding-left: 10px;
      background-color: white;
      /*margin-top: 5px;*/
    }
    .layout-main-content {
      margin: 10px auto;
      background-color: white;
      width: 99%;
    }
  }

</style>
