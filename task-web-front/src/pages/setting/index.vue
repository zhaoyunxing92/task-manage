<template>
  <div>
    <Col span="4">
    <Card>
      <p slot="title">
        <Icon type="gear-b"></Icon> &nbsp;设置面板
      </p>
      <a href="javascript:void(0)" slot="extra">
        <Icon slot="extra" type="ios-skipbackward" size="20"></Icon>
      </a>

      <Menu :active-name="$route.name" width="auto" @on-select="goToPath">
        <MenuItem :name="menu.name" v-for="(menu,index) in $store.state.settingMenu" :key="index">
          <Icon :type="menu.icon" :color="menu.iconColor" :size="menu.iconSize"></Icon>
          {{menu.menuName}}
        </MenuItem>
      </Menu>
    </Card>

    </Col>
    <Col span="20">
    <Card>

      <p slot="title">
        <Icon :type="$route.meta.icon" :color="$route.meta.iconColor" :size="$route.meta.iconSize"></Icon>
        &nbsp;{{$route.meta.menuName}}&nbsp;
      </p>


      <a v-show="addTypeName!==''" href="javascript:void(0)" slot="extra" @click.prevent="changeLimit">
        <Icon type="plus-circled"></Icon>
        {{addTypeName}}
      </a>

      <router-view/>
    </Card>
    </Col>
  </div>
</template>
<script>
  import ObjectUtils from '../../utils/ObjectUtils'
  export default {
    name: "task-org-setting",
    data () {//数据
      return {
        addTypeName: '',//右脚添加名称
      }
    },
    methods: {
      //跳转
      goToPath(key){
        this.$router.push({name: key});
      },
      //设置右脚添加名称
      getAddTypeName(key){
        let that = this;
        switch (key) {
          case 'add_project':
            that.addTypeName = '创建项目';
            return;
          case 'add_user':
            that.addTypeName = '添加成员';
            return;
          case 'add_role':
            that.addTypeName = '添加角色';
            return;
          case 'add_task_type':
            that.addTypeName = '添加类型';
            return;
          case 'add_task_status' :
            that.addTypeName = '添加状态';
            return;
          default:
            that.addTypeName = '';
        }
      }
    },
    watch: {
      '$route.meta.type': function (val) {
        this.getAddTypeName(val);
      }
    },

    created(){
      this.getAddTypeName(this.$route.meta.type);
    },
  }
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
