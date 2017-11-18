<template>
  <div class="login-layout">
    <div class="content">
      <Card class="login-card" :bordered="false">
        <p slot="title">
          <Icon type="log-in"></Icon>
          欢迎登录
        </p>
        <div class="form-con">
          <Form ref="LoginForm" :model="LoginForm" :rules="LoginFormRule">
            <FormItem prop="account">
              <Input v-model="LoginForm.account" placeholder="请输入邮箱/手机号/账号">
              <span slot="prepend">
                   <Icon :size="16" type="person"></Icon>
                </span>
              </Input>
            </FormItem>
            <FormItem prop="password">
              <Input type="password" v-model="LoginForm.password" placeholder="请输入密码">
              <span slot="prepend">
                  <Icon :size="14" type="locked"></Icon>
                </span>
              </Input>
            </FormItem>
            <FormItem>
              <Button type="primary" shape="circle" long :loading="loading" @click="login('LoginForm')">登录</Button>
            </FormItem>
          </Form>
          <!--<p class="login-tip">输入任意用户名和密码即可</p>-->
        </div>
      </Card>

    </div>

  </div>

</template>
<style type="text/less" lang="less">
  .login-layout {
    .content {
      .login-card {
        margin: 80px auto;
        width: 320px;
        .ivu-card-head { //登录标题居中显示
          text-align: center;
        }
      }
    }
  }
</style>
<script>
  import Api from '@Api'
  import HttpUtils from '../utils/HttpUtils'
  import ObjectUtils from '../utils/ObjectUtils'
  export default {
    data () {
      return {
        loading: false,
        LoginForm: {
          account: '2385585770@qq.com',
          password: '123456'
        },
        LoginFormRule: {
          account: [
            {required: true, message: '请填写用户名', trigger: 'blur'},
            {required: true, message: '请填写用户名', trigger: 'change'},
          ],
          password: [
            {required: true, message: '请填写密码', trigger: 'blur'},
            {required: true, message: '请填写密码', trigger: 'change'},
//            {type: 'string', min: 6, message: '密码长度不能小于6位', trigger: 'blur'}
          ]
        }
      }
    },
    methods: {
      login(name) {
        let that = this;
        that.$refs[name].validate((valid) => {
          if (valid) {
            that.loading = true;
            HttpUtils.baseRequest(Api.auth.login.url, Api.auth.login.method, that.LoginForm, function (data) {
              let userInfo = {
                account: ObjectUtils.getValue(data.account, that.LoginForm.account),
                email: ObjectUtils.getValue(data.email),
                avatar: ObjectUtils.getValue(data.avatar,'https://avatars1.githubusercontent.com/u/18088210')
              };
              localStorage.setItem("userInfo", JSON.stringify(userInfo));
              that.$router.push(Api.auth.login.successurl);
            }, function (error) {
              //that.$refs[name].resetFields();
              that.loading = false;
              that.$Message.error(error);
            })

            //this.$Message.success('提交成功!');
          } else {
            that.loading = false;
          }
        })
      }
    }
  }
</script>

