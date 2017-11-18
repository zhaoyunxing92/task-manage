/**
 * @author :  sunny
 * @date : 2017/9/11 16:20
 * @description : 统一处理请求
 */
import axios from "axios";
import config from "../../config";
import ObjectUtils from "./ObjectUtils";

// /*axios.defaults.headers.common['Content-Type'] = 'application/json;charset=UTF-8';
// axios.defaults.headers.common['token'] = 'sunny'*/
class HttpUtils {
  constructor() {
    // axios.defaults.withCredentials=true,
    this.log = false;
    /** 默认超时30秒 */
    this.defaultTimeOut = 3000;
    this.defaultMaxStatus = 600;
    this.defaultMinStatus = 200;
    /** 默认url */
    this.defaultServiceUrl = process.env.NODE_ENV === 'production' ? ObjectUtils.getValue(config.build.serviceUrl, '') : ObjectUtils.getValue(config.dev.serviceUrl, '');
    this.withCredentials = true;
  };

  /**
   *  两个参数： url，success(fun)
   *  三个参数：[url,type,success(fun)] [url,success(fun)，error(fun)]  [url  params  success(fun) get]
   *  四个参数：[url,params,success(fun),error(fun) GET] [url,type,success(fun),error(fun)]  [url,type,params，success(fun)]
   *
   * @param url
   * @param type
   * @param params
   * @param success
   * @param error
   */
  baseRequest(url, type = 'GET', params, success, error) {
    let _ = this;
    axios({
      baseURL: _.defaultServiceUrl,
      method: type,
      url: url,
      data: params,
      timeout: _.defaultTimeOut,
      withCredentials: _.withCredentials,
      validateStatus: function (status) {
        return status >= _.defaultMinStatus && status <= _.defaultMaxStatus;
      }
    }).then(function (res) {
      let code = ObjectUtils.getValue(res.data.code, -1);
      let msg = ObjectUtils.getValue(res.data.msg, res.msg);
      let data = ObjectUtils.getValue(res.data.data);

      if (code !== 0) {
        error && error(msg);
      } else {
        success && success(data);
      }
    }).catch(function (err) {
      let errs = err.toString();

      /**
       * timeout
       */
      if (errs.indexOf('timeout') >= -1) {
        error && error("服务器连接超时,请稍后重试！");
      } else if (errs.indexOf('Network Error') >= -1) {
        error && error("网络异常！");
      } else {
        error && error("服务器异常请稍后重试！");
      }

      //error && error(err);
    });
  }

  baseTestRequest(url, type = 'GET', success, error) {
    let _ = this;
    axios({
      baseURL: _.defaultServiceUrl,
      method: type,
      url: url,
      data: {},
      timeout: _.defaultTimeOut,
      withCredentials: _.withCredentials,
      validateStatus: function (status) {
        return status >= _.defaultMinStatus && status <= _.defaultMaxStatus;
      }
    }).then(function (res) {
      let code = ObjectUtils.getValue(res.data.code, -1);
      let msg = ObjectUtils.getValue(res.data.msg, res.msg);
      let data = ObjectUtils.getValue(res.data.data);

      if (code !== 0) {
        error && error(msg);
      } else {
        success && success(data);
      }
    }).catch(function (err) {
      let errs = err.toString();
      /**
       * timeout
       */
      if (errs.indexOf('timeout') >= -1) {

      }
      error && error(err);
    });
  }

  /**
   * post
   * @param url
   * @param params
   * @param success
   * @param err
   */
  doPost(url, params, success, err) {
    this.baseRequest(url, 'POST', this.isParams(arguments.length, params), success, err);
  }

  /**
   * get
   * @param url
   * @param params
   * @param success
   * @param err
   */
  doGet(url, params, success, err) {
    this.baseRequest(url, 'GET', this.isParams(arguments.length, params), success, err);
  }

  /**
   * put
   * @param url
   * @param params
   * @param success
   * @param err
   */
  doPut(url, params, success, err) {
    this.baseRequest(url, 'PUT', this.isParams(arguments.length, params), success, err);
  }

  /**
   * del
   * @param url
   * @param params
   * @param success
   * @param err
   */
  doDel(url, params, success, err) {
    this.baseRequest(url, 'DELETE', this.isParams(arguments.length, params), success, err);
  }

  /**
   * 判断是否参数 （内部使用private）
   *
   * @param argumentsSize
   * @param params
   */
  isParams(argumentsSize, params) {
    if (argumentsSize == 3 && typeof params === 'function') {
      return {};
    } else {
      return params;
    }
  }
}
export default new HttpUtils();
