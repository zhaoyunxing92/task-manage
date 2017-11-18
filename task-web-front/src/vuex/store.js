/**
 * @author :  sunny
 * @date : 2017.10.24 10:40
 * @description :
 */
import Vue from "vue";
import Vuex from "vuex";
import {appMain} from "../router/index";

Vue.use(Vuex);
const store = new Vuex.Store({
  state: { //state 定义了应用状态的数据结构，同样可以在这里设置默认的初始状态。
    orgs: [],
    appMenus: [],//app头部菜单
    currentOrgId: '',//当前组织
    menuTheme: '', // 菜单主题
    orgMenuList: [], //组织菜单
    workbenchMenu: [], //工作台菜单
    settingMenu: [],//设置菜单
    pageOpenedList: [],   //默认打开页面],  // 面包屑数组
    currentPageName: '',//当前展开的菜单名称
    openedSubmenuArr: [],  // 要展开的菜单数组
  },
  actions: {},
  mutations: {
    //添加
    addOrgs(state, obj){
      state.orgs.push(obj);
    },
    setCucurrentOrgId(state, uid){
      state.currentOrgId = uid;
    },
    setMenuList (state){
      // return;
      // let accessCode = parseInt(Cookies.get('access'));
      let headMenus = [];
      let workbenchMenus = [];
      let settingMenus = [];
      appMain.forEach(item => {
        if (item.children.length > 0) {
          item.children.forEach(headMenu => {
            //头部导航
            if (!headMenu.hide) {
              headMenus.push({
                name: headMenu.name,
                icon: headMenu.meta.icon,
                menuName: headMenu.meta.menuName,
                right: headMenu.meta.right,
                iconColor: headMenu.meta.iconColor
              });

            }
            //左侧菜单 ---工作台
            if (headMenu.workbenchMenu && headMenu.children.length > 0) {
              headMenu.children.forEach(leftMenu => {
                workbenchMenus.push({
                  name: leftMenu.name,
                  icon: leftMenu.meta.icon,
                  menuName: leftMenu.meta.menuName,
                  iconColor: leftMenu.meta.iconColor
                });
              })
            }
            //左侧菜单 ---setting
            if (headMenu.settingMenu && headMenu.children.length > 0) {
              headMenu.children.forEach(leftMenu => {
                settingMenus.push({
                  name: leftMenu.name,
                  icon: leftMenu.meta.icon,
                  menuName: leftMenu.meta.menuName,
                  iconColor: leftMenu.meta.iconColor
                });
              })
            }

          });
        }


      });
      state.orgMenuList = headMenus;
      state.workbenchMenu = workbenchMenus;
      state.settingMenu = settingMenus;
      // state.orgs.push({'name':'test'})
    }
  },
  getters: {},
  modules: {}
});
export default store
