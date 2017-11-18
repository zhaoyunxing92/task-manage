<template>
  <Card>
    <!--<p slot="title">-->
      <!--<Icon type="plus-circled" color="#619fe7"></Icon>-->
      <!--创建组织-->
    <!--</p>-->
    <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
      <FormItem label="组织uid" prop="uid">
        <Input v-model="formValidate.uid" disabled/>
      </FormItem>
      <FormItem label="组织名称" prop="name">
        <Input v-model="formValidate.name" placeholder="请输入组织名称"/>
      </FormItem>

      <FormItem label="地址" prop="address">
        <Input v-model="formValidate.address" type="textarea" :autosize="{minRows: 1,maxRows: 2}"
               placeholder="请输入..."/>
      </FormItem>

      <FormItem label="简介" prop="intro">
        <Input v-model="formValidate.intro" type="textarea" :autosize="{minRows: 5,maxRows: 8}"
               placeholder="请输入..."/>
      </FormItem>
      <FormItem label="是否公开">
        <i-switch v-model="formValidate.open" size="large">
          <span slot="open">是</span>
          <span slot="close">否</span>
        </i-switch>
      </FormItem>

      <FormItem style="text-align: center">
        <Button type="primary" shape="circle" :loading="loading" @click="handleSubmit('formValidate')">保存</Button>
        <!--<Button type="ghost" shape="circle" @click="goBack" style="margin-left: 10px">返回</Button>-->
      </FormItem>
    </Form>
  </Card>

</template>
<script>
  import Api from '@Api'
  import HttpUtils from '../../utils/HttpUtils'
  import ObjectUtils from '../../utils/ObjectUtils'
  export default {
    data () {
      return {
        loading: false,
        // updateForm: false,//是否更新表单
        formValidate: {
          name: '',
          open: true, //是否公开
          address: '', //地址
          intro: '' //简介
        },
        ruleValidate: {
          name: [
            {required: true, message: '姓名不能为空', trigger: 'blur'}
          ],
          address: [
            {required: true, message: '地址不能为空', trigger: 'blur'},
            {type: 'string', min: 2, message: '地址不能少于2个字符', trigger: 'blur'},
            {type: 'string', max: 450, message: '地址最长450个字符', trigger: 'blur'}
          ],
          intro: [
            {required: true, message: '简介不能为空', trigger: 'blur'},
            {type: 'string', min: 2, message: '简介不能少于2个字符', trigger: 'blur'},
            {type: 'string', max: 450, message: '简介最长450个字符', trigger: 'blur'}
          ]
        }
      }
    },
    methods: {
      handleSubmit (name) {
        let that = this;

        that.$refs[name].validate((valid) => {
          if (valid) {
            that.loading = true;
            HttpUtils.baseRequest(Api.org.create.url, Api.org.create.method, that.formValidate, function (data) {
              console.log(data)
              that.$Message.success('创建成功');
              that.goBack();
            }, function (error) {
              that.loading = false;
              that.$Message.error(error);
            })
          } else {
            that.$Message.error('表单验证失败!');
          }
        })
      },
      getOrgInfo(){
        let that = this;
        HttpUtils.baseRequest(Api.org.info.url, Api.org.info.method, {'uId': that.state.currentOrgId}, function (data) {
          console.log(data)
          that.$Message.success('创建成功');
        }, function (error) {
          that.loading = false;
          that.$Message.error(error);
        })
      }
    }
  }
</script>
<style type="text/less" lang="less">
  .create-org-layout {
    width: 98%;
    margin: 0 auto;
    padding: 20px;
    background-color: white;
  }
</style>
