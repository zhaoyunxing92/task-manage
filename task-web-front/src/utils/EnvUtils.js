/**
 * @author :  sunny
 * @date : 2017/9/13 9:33
 * @description :   判断环境
 */
class EnvUtils {
  userAgent () {
    return navigator.userAgent.toLowerCase()
  }

  /**
   * 是否微信环境
   */
  isWechat () {
    let userAgent = this.userAgent()
    return userAgent.indexOf('micromessenger') > -1
  }

  /**
   * 是否是手机端钉钉
   */
  isDingTalk (){
    let userAgent = this.userAgent()
    return userAgent.indexOf('dingtalk') > -1
  }

  /***
   * 获取钉钉加载状态
   */
  getDingTalkLoadStatus (){
    return sessionStorage.getItem('dingTalkLoadStatus') === 'true';
  }

  /**
   * 设置钉钉加载状态
   * @param status
   */
  setDingTalkLoadStatus (status){
    sessionStorage.setItem('dingTalkLoadStatus',status);
  }
  /**
   * 是否是pc端钉钉
   */
  isDingTalkPc (){

  }

  /**
   * 是否web
   * @returns {boolean}
   */
  isWeibo (){
    let userAgent = this.userAgent()
    return userAgent.indexOf('weibo') > -1
  }

  /**
   * 是否是支付宝
   * @returns {boolean}
   */
  isAlipay (){
    let userAgent = this.userAgent()
    return userAgent.indexOf('alipay') > -1
  }
}
export default new EnvUtils()
