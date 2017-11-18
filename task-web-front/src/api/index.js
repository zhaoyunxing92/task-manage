/**
 * @author :  sunny
 * @date : 2017.10.23 13:17
 * @description :
 */
module.exports = {
  auth: {
    'login': {url: 'auth/login', method: 'post', successurl: 'task'}, //登录
    'active': 'auth/active' //激活
  },
  org: {
    'orgs': {url: 'org/current', method: 'post', successurl: ''}, //当前人的组织
    'create': {url: 'org/add', method: 'post',successurl: 'org/info/'}, //创建组织
    'info':{url:'org/info',method:'get'}  //组织信息
  }
}

