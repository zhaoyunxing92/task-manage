/**
 * @author :  sunny
 * @date : 2017/10/10 14:10
 * @description :
 */
class ObjectUtils {
  constructor () {
    //邮箱正则
    this.emailReg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/
    //手机号码正则
    this.mobileReg = /^[1][3,4,5,7,8][0-9]{9}$/
    //前后空白正则
    this.blankReg = /(^\s*)|(\s*$)/g
    //全部空格
    this.blankAllReg = /\s/g

  }

  /**
   * 判断是否邮箱
   * @param str
   */
  isEmail (str) {
    return this.emailReg.test(str)
  }
  /**数组去重复*/
  ArrayUnique(arr) {
    let result = [], hash = {};
    for (let i = 0, elem; (elem = arr[i]) != null; i++) {
      if (!hash[elem]) {
        result.push(elem);
        hash[elem] = true;
      }
    }
    return result;
  }
  /**
   * 是否手机号码
   * @param str
   */
  isMobile (str) {
    return this.mobileReg.test(str)
  }

  /**
   * 判断是否为空
   * @param obj
   * @returns {boolean}
   */
  isNull (obj) {
    return obj === undefined || obj === null
  }

  /**
   * 判断是否为不为空
   * @param obj
   * @returns {boolean}
   */
  isNotNull (obj) {
    return obj !== undefined && obj !== null
  }

  /**
   * 去除前后空格
   * @param obj
   */
  trimStr (obj) {
    return this.objectFormat(obj, this.blankAllReg)
  }

  /**
   * 去除全部空格
   * @param obj
   * @returns {string}
   */
  triamStrAll (obj) {
    return this.objectFormat(obj, this.blankAllReg)
  }

  /**
   * 根据正则格式化对象，目前只处理string类型的数据
   * @param obj
   * @param reg
   * @returns {*}
   */
  objectFormat (obj, reg) {
    if (this.isNotNull(obj) && typeof obj === 'string') {
      return obj.replace(reg, '')
    } else if (this.isNull(obj)) {
      return ''
    } else if (typeof obj !== 'string') {
      return obj
    }
  }

  /**
   * 判断是否空白
   * @param obj
   * @returns {boolean}
   */
  isBlank (obj) {
    return this.isNull(obj) || this.trimStr(obj) === ''
  }

  /**
   *   判断是否空白
   * @param obj
   * @returns {boolean}
   */
  isNotBlank (obj) {
    return !this.isNull(obj) || this.trimStr(obj) !== ''
  }

  /**
   * 给一个值返回改值，undefined/null 则返回defaultvalue
   * @param obj
   * @param defaultValue
   * @returns {*}
   */
  getValue (obj, defaultValue = '') {
    return this.isNull(obj) ? defaultValue : obj
  }
}
export default new ObjectUtils()
