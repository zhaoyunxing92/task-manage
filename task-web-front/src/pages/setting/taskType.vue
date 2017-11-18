<template>
      <div>
        {{$route.meta.type}}
      </div>
</template>
<script>
  /*公用界面*/
  export default {
    name: "task-type",
    data () {//数据
      return {
        columns1: [
          {
            title: '姓名',
            key: 'name'
          },
          {
            title: '年龄',
            key: 'age'
          },
          {
            title: '地址',
            key: 'address'
          }
        ],
        data1: [
          {
            name: '王小明',
            age: 18,
            address: '北京市朝阳区芍药居'
          },
          {
            name: '张小刚',
            age: 25,
            address: '北京市海淀区西二旗'
          },
          {
            name: '李小红',
            age: 30,
            address: '上海市浦东新区世纪大道'
          },
          {
            name: '周小伟',
            age: 26,
            address: '深圳市南山区深南大道'
          }
        ]
      }
    },

    methods: {
      handleSelectAll (status) {
       // this.$refs.selection.se
        this.$refs.selection.selectAll(status);
      }
    },
    watch: {
      //一个对象，键是需要观察的表达式，值是对应回调函数。值也可以是方法名，或者包含选项的对象。Vue 实例将会在实例化时调用$watch()，遍历 watch 对象的每一个属性。
    },
    beforeCreate(){
      //在实例初始化之后，数据观测(data observer) 和 event/watcher 事件配置之前被调用
    },
    created(){
    // console.log(this.$route.meta.type)
    },

  }
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
