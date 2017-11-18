<template>
  <div>
    <Col span="4">
    <Card>
      <p slot="title">
        <Icon type="android-desktop"></Icon> &nbsp;筛选列表
      </p>
      <h4><Icon type="pricetag"></Icon> &nbsp;问题类型</h4>
      <Select v-model="model10" multiple>
         <Option v-for="item in cityList" :value="item.value" :key="item.value">
           {{ item.label }}</Option>
      </Select>
      <br/>
      <br/>
      <h4><Icon type="pricetag"></Icon> &nbsp;状态</h4>
      <hr/>
      <Checkbox v-model="single">新建</Checkbox>
      <Checkbox v-model="single">关闭</Checkbox>
      <Checkbox v-model="single">处理</Checkbox>

      <br/>
      <br/>
      <h4><Icon type="pricetag"></Icon> &nbsp;状态</h4>
      <hr/>
      <Checkbox v-model="single">新建</Checkbox>
      <Checkbox v-model="single">关闭</Checkbox>
      <Checkbox v-model="single">处理</Checkbox>

      <br/>
      <br/>
      <h4><Icon type="pricetag"></Icon> &nbsp;状态</h4>
      <hr/>

      <Checkbox v-model="single">新建</Checkbox>
      <Checkbox v-model="single">关闭</Checkbox>
      <Checkbox v-model="single">处理</Checkbox>
      <Checkbox v-model="single">处理</Checkbox>
      <Checkbox v-model="single">处理</Checkbox>
      <Checkbox v-model="single">处理</Checkbox><Checkbox v-model="single">处理</Checkbox>

    </Card>

    </Col>
    <Col span="20">
    <Card>
      <p slot="title">
        <Icon :type="$route.meta.icon"></Icon>
        &nbsp;{{$route.meta.menuName}}列表&nbsp;
      </p>
      <a href="#" slot="extra" @click.prevent="changeLimit">
        <Icon type="refresh"></Icon>
        刷新
      </a>

    </Card>

    </Col>
  </div>
</template>
<script>
  export default {
    name: "task-issues",
    data () {//数据
      return {
        single:'dd',
        cityList: [
          {
            value: 'beijing',
            label: '北京市'
          },
          {
            value: 'shanghai',
            label: '上海市'
          },
          {
            value: 'shenzhen',
            label: '深圳市'
          },
          {
            value: 'hangzhou',
            label: '杭州市'
          },
          {
            value: 'nanjing',
            label: '南京市'
          },
          {
            value: 'chongqing',
            label: '重庆市'
          }
        ],
        model10: []
      }
    },
    computed: {
      //计算属性将被混入到 Vue 实例中。所有 getter 和 setter 的 this 上下文自动地绑定为 Vue 实例。计算属性的结果会被缓存，除非依赖的响应式属性变化才会重新计算。注意，如果实例范畴之外的依赖 (比如非响应式的 not reactive) 是不会触发计算属性更新的。
    },
    methods: {
      //methods 将被混入到 Vue 实例中。可以直接通过 VM 实例访问这些方法，或者在指令表达式中使用。方法中的 this 自动绑定为 Vue 实例。
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
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
