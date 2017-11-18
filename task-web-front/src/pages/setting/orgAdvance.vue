<template>
  <div>
    <Button type="primary" @click="showTransferOrg = true" shape="circle">转移团队</Button>

    <h4>团队转移后您将没有权限</h4>
    <br/>
    <Poptip
      confirm
      title="您确定要删除该组织吗？"
      @on-ok="delOrg">
      <Button type="error" shape="circle" >删除团队</Button>
    </Poptip>

    <h4>删除团队后数据都就会被清理，请谨慎操作</h4>


    <Modal
      v-model="showTransferOrg"
      :mask-closable="false">
      <p slot="header" style="color:#f60;text-align:center">
        <Icon type="information-circled"></Icon>
        <span>确认转让</span>
      </p>
      <div style="height: 100px;">

        <Select v-model="model8" filterable clearable placeholder="可以搜索您要转移的人">
          <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
        </Select>
      </div>
      <div slot="footer">
        <Button type="success" shape="circle" @click="transferOrgModal('0')">取消</Button>
        <Button type="error" shape="circle" @click="transferOrgModal('1')">确定转移</Button>
      </div>
    </Modal>
  </div>
</template>
<script>
  export default {
    name: "task-org-advance",
    data () {//数据
      return {
        showTransferOrg: false,//显示转移窗口
        showDelOrg: false,//删除组织模态框
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
        model8: ''
      }
    },
    methods: {
      // 转移项目模态框
      transferOrgModal(flag){
        let that = this;
        if (flag == 0) {
          that.showTransferOrg = false;
        }
      },
      //删除组织
      delOrg(){
        this.$Modal.confirm({
          title: '身份确认',
          content: '<Input v-model="value" class="ivu-input" placeholder="请输入密码"/>',
          loading: true,
          okText:'删除',
          onOk: () => {
            setTimeout(() => {
              this.$Modal.remove();
              this.$Message.info('异步关闭了对话框');
            }, 2000);
          }
        });
      }
    },

    created(){
      //实例已经创建完成之后被调用。在这一步，实例已完成以下的配置：数据观测(data observer)，属性和方法的运算，watch/event 事件回调。然而，挂载阶段还没开始，$el 属性目前不可见
    },
  }
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
