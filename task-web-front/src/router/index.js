// const Main = () => import(/* webpackChunkName: "main" */'../apps/main')
// const Login = () => import(/* webpackChunkName: "login" */ '../apps/login')
//
// const Home = () => import(/* webpackChunkName: "home" */'../apps/home/index')
// /**项目模块*/
// const ProjectHome = () => import('../apps/project/index');
// const ProjectMember = () => import('../apps/project/member');
// const OrgPrijectList = () => import('../apps/project/list');
// const OrgPrijectInfo = () => import('../apps/project/info');
//
//
// /**团队模块*/
// const OrgHome = () => import('../apps/org/index');
// const OrgDetails = () => import('../apps/org/details');
// const OrgCreate = () => import('../apps/org/createOrg');
// const Orgs = () => import('../apps/org/orgs');
// const OrgSetting = () => import('../apps/org/setting');
// const OrgSurvey = () => import('../apps/org/survey');//团队概览
//
// /**团队设置*/
// const OrgSettingAdvance = () => import('../apps/org/setting/advance');//高级设置
// const OrgSettingOrgInfo = () => import('../apps/org/setting/orgInfo');
// const OrgTaskType = () => import('../apps/org/setting/taskType');
// const OrgSettingProjects = () => import('../apps/org/setting/projects');
// const OrgSettingOrgUsers = () => import('../apps/org/setting/orgUsers')
//
// const Message = () => import('../apps/msg/index')
//
// /**项目列表*/
//
//
// /**工作台*/
// const WorkbenchIndex = () => import('../apps/workbench/index');
// const AssignedToMe = () => import('../apps/workbench/assigned_to_me');
//
//
// /**问题模块*/
// const Issues = () => import('../apps/issues/index');
// //
// export const loginRouter = {
//   path: '/login',
//   name: 'login',
//   meta: {
//     title: 'task - 登录'
//   },
//   component: Login
// };
// //
// export const otherRouter = {
//   path: '/task',
//   name: 'otherRouter',
//   component: Main,
//   redirect: '/home',
//   children: [
//     {
//       path: '/home',
//       title: '首页',
//       name: 'home_index',
//       meta: {title: '首页'},
//       component: Home
//     },
//     {
//       path: "/message",
//       title: '消息',
//       name: 'msg_index',
//       meta: {title: '消息'},
//       component: Message
//     },
//     {
//       path: "/create/org",
//       title: '创建组织',
//       name: 'org_create',
//       meta: {title: '创建组织'},
//       component: OrgCreate
//     },
//     {
//       path: "/org/info/:id",
//       title: '组织信息',
//       name: 'org_info',
//       meta: {title: '组织信息'},
//       component: OrgDetails
//     }
//   ]
// };

// 菜单
// export const appMenuRouter = [
//   {
//     path: '/org',
//     name: 'org',
//     title: '组织',
//     component: Main,
//     children: [
//       {
//         path: '/',
//         title: '组织',
//         icon: 'arrow-graph-up-right',
//         name: 'orgs',
//         meta: {title: '组织列表'},
//         component: Orgs
//       },
//       {
//         path: ':uid',
//         orgMenu: true,
//         name: 'org-home',
//         meta: {title: '首页'},
//         redirect: '/org/:uid/outline',
//         component: OrgHome,
//         children: [
//           {
//             path: 'workbench',
//             name: 'main-workbench',
//             workbenchMenu: true,
//             meta: {title: '工作台', icon: 'home', menuName: '工作台'},
//             redirect: '/org/:uid/workbench/assigned',
//             component: WorkbenchIndex,
//             children: [
//               {
//                 path: 'assigned',
//                 //  alias: ['abc'],
//                 name: 'workbench-assigned',
//                 meta: {title: '指给我的', icon: 'at', menuName: '指给我的'},
//                 component: AssignedToMe,
//               },
//               {
//                 path: 'create',
//                 name: 'workbench-me-create',
//                 meta: {title: '我提出的', icon: 'plus', menuName: '我提出的'},
//                 component: AssignedToMe,
//               },
//               {
//                 path: 'follow',
//                 name: 'workbench-me-follow',
//                 meta: {title: '我关注的', icon: 'star', menuName: '我关注的'},
//                 component: AssignedToMe,
//               },
//               {
//                 path: 'finish',
//                 name: 'workbench-me-finish',
//                 meta: {title: '我完成的', icon: 'document-text', menuName: '我完成的'},
//                 component: AssignedToMe,
//               }
//             ]
//           },
//           {
//             path: 'outline',
//             name: 'main-outline',
//             meta: {title: '概览', icon: 'navicon-round', menuName: '概览'},
//             component: OrgSurvey
//           },
//           {
//             path: 'issues',
//             name: 'main-issues',
//             meta: {title: '任务列表', icon: 'document-text', menuName: '任务'},
//             component: Issues
//           },
//           {
//             path: 'projects',
//             name: 'main-project',
//             projectMenu: true,
//             meta: {title: '项目列表', icon: 'pie-graph', menuName: '项目'},
//             component: OrgPrijectList,
//             children: [
//               {
//                 path: 'info',
//                 name: 'main-project-list',
//                 meta: {title: '项目列表', icon: 'pie-graph', menuName: '项目列表'},
//                 component: OrgPrijectInfo,
//               }
//             ]
//           },
//           {
//             path: 'setting',
//             name: 'main-setting',
//             settingMenu: true,
//             meta: {title: '设置', icon: 'settings', menuName: '设置'},
//             redirect: '/org/:uid/setting/info',
//             component: OrgSetting,
//             children: [
//               {
//                 path: 'info',
//                 //  alias: ['abc'],
//                 name: 'main-setting-info',
//                 meta: {title: '团队信息', icon: 'information-circled', menuName: '团队信息'},
//                 component: OrgSettingOrgInfo,
//               },
//               {
//                 path: 'projects',
//                 //  alias: ['abc'],
//                 name: 'main-setting-projects',
//                 meta: {title: '团队项目', icon: 'pie-graph', menuName: '团队项目', type: 'add_project'},
//                 component: OrgSettingProjects,
//               },
//               {
//                 path: 'user',
//                 //  alias: ['abc'],
//                 name: 'main-setting-user',
//                 meta: {title: '团队成员', icon: 'person-stalker', menuName: '团队成员', type: 'add_user'},
//                 component: OrgTaskType,
//               },
//               {
//                 path: 'role',
//                 //  alias: ['abc'],
//                 name: 'main-setting-role',
//                 meta: {title: '团队角色', icon: 'eye', menuName: '团队角色', type: 'add_role'},
//                 component: OrgTaskType,
//               },
//
//               {
//                 path: 'task_type',
//                 //  alias: ['abc'],
//                 name: 'main-setting-task-type',
//                 meta: {title: '任务类型', icon: 'bookmark', menuName: '任务类型', iconSize: '18', type: 'add_task_type'},
//                 component: OrgTaskType,
//               },
//               {
//                 path: 'task_status',
//                 //  alias: ['abc'],
//                 name: 'main-setting-task-status',
//                 meta: {title: '任务状态', icon: 'ribbon-a', menuName: '任务状态', type: 'add_task_status'},
//                 component: OrgTaskType,
//               },
//               {
//                 path: 'advance',
//                 //  alias: ['abc'],
//                 name: 'main-setting-advance',
//                 meta: {title: '高级设置', icon: 'android-warning', menuName: '高级设置', iconColor: '#ed3f14', iconSize: '18'},
//                 component: OrgSettingAdvance,
//               }
//             ]
//           },
//           {
//             path: 'add_user',
//             name: 'main-add-user',
//             meta: {title: '邀请好友', icon: 'person-add', menuName: '邀请好友', right: true},
//             component: ProjectHome
//           }
//         ]
//       }
//     ]
//   }
// ];

/**main*/
const Main = () => import('../pages/main');
const Home = () => import('../pages/home/index');

/**工作台*/
const WorkbenchIndex = () => import('../pages/workbench/index');
const AssignedToMe = () => import('../pages/workbench/assigned_to_me'); //指给我的

/**任务*/
const Task = () => import('../pages/task/index'); //任务列表


/**项目列表*/
const Project = () => import('../pages/project/index'); //项目列表


/**设置*/
const Setting = () => import('../pages/setting/index');
const SettingOrgInfo = () => import('../pages/setting/orgInfo');//组织信息
const SettingOrgAdvance=()=>import('../pages/setting/orgAdvance'); //组织高级设置
const SettingOrgUsers=()=>import('../pages/setting/orgUsers'); //组织成员
const SettingOrgRole=()=>import('../pages/setting/orgRole');//组织角色
const SettingOrgProjects=()=>import('../pages/setting/orgProjects');//组织项目
const SettingOrgThirdparty=()=>import('../pages/setting/orgThirdparty'); //第三方绑定数据

/**组织*/
const AddOrg = () => import('../pages/org/addOrg');
const AddOrgUser = () => import('../pages/org/addUser');
const OrgList = () => import('../pages/org/orgList');

/**me*/
const AppMe =()=>import('../pages/me/index');



/**other*/
const Login = () => import(/* webpackChunkName: "login" */ '../pages/login');


export const appMain = [
  {
    path: "/main",
    title: '首页',
    name: 'app-main',
    meta: {title: '首页'},
    redirect: '/outline',
    component: Main,
    children: [
      {
        path: '/workbench',
        name: 'app-workbench',
        workbenchMenu: true,
        meta: {title: '工作台', icon: 'home', menuName: '工作台'},
        redirect: '/workbench/assigned',
        component: WorkbenchIndex,
        children: [
          {
            path: 'assigned',
            //  alias: ['abc'],
            name: 'workbench-assigned',
            meta: {title: '指给我的', icon: 'at', menuName: '指给我的'},
            component: AssignedToMe,
          },
          {
            path: 'create',
            name: 'workbench-me-create',
            meta: {title: '我提出的', icon: 'plus', menuName: '我提出的'},
            component: AssignedToMe,
          },
          {
            path: 'follow',
            name: 'workbench-me-follow',
            meta: {title: '我关注的', icon: 'star', menuName: '我关注的'},
            component: AssignedToMe,
          },
          {
            path: 'finish',
            name: 'workbench-me-finish',
            meta: {title: '我完成的', icon: 'document-text', menuName: '我完成的'},
            component: AssignedToMe,
          }
        ]
      },

      {
        path: '/outline',
        name: 'app-home',
        meta: {title: '概览', icon: 'navicon-round', menuName: '概览'},
        component: Home
      },
      {
        path: '/tasks',
        name: 'app-tasks',
        meta: {title: '任务列表', icon: 'document-text', menuName: '任务'},
        component: Task
      },
      {
        path: '/projects',
        name: 'app-projects',
        meta: {title: '项目', icon: 'document-text', menuName: '项目'},
        component: Project
      },
      {
        path: '/setting',
        name: 'app-setting',
        settingMenu: true,
        meta: {title: '设置', icon: 'document-text', menuName: '设置'},
        component: Setting,
        redirect: '/setting/orgInfo',
        children: [
          {
            path: 'orgInfo',  //组织信息
            name: 'app-setting-org-info',
            component: SettingOrgInfo,
            meta: {title: '团队信息', icon: 'document-text', menuName: '团队信息'},
          },
          {
            path: 'projects',
            name: 'app-setting-org-project',
            component: SettingOrgProjects,
            meta: {title: '团队项目', icon: 'document-text', menuName: '团队项目'},
          },
          {
            path: 'users',  //组织信息
            name: 'app-setting-org-user',
            component: SettingOrgUsers,     //SettingOrgRole
            meta: {title: '团队成员', icon: 'document-text', menuName: '团队成员'},
          },

          {
            path: 'role',  //组织信息
            name: 'app-setting-org-role',
            component: SettingOrgRole,     //thirdparty
            meta: {title: '团队角色', icon: 'document-text', menuName: '团队角色'},
          },
          {
            path: 'thirdparty',  //组织信息
            name: 'app-setting-org-thirdparty',
            component: SettingOrgThirdparty,     //thirdparty
            meta: {title: '第三方数据', icon: 'document-text', menuName: '第三方'},
          },
          {
            path: 'advance',  //高级设置
            name: 'app-setting-org-advance',
            component: SettingOrgAdvance,
            meta: {title: '高级设置', icon: 'document-text', menuName: '高级设置'},
          }
        ]
      },
      {
        path: '/orgs',
        name: 'app-toggle-org',
        meta: {title: '团队列表', icon: 'document-text', menuName: '切换团队'},
        component: OrgList
      },
      {
        path: '/add-user',
        name: 'app-add-org',
        meta: {title: '邀请好友', icon: 'document-text', menuName: '邀请好友'},
        component: AddOrgUser
      },
      {
        path: '/add-org',
        name: 'app-user-logout',
        redirect: '/login',
        meta: {title: '退出', icon: 'power', menuName: '', right: true, iconColor: 'red'},
        component: AddOrg
      },
      {
        path: '/userInfo',
        name: 'app-user-info',
        meta: {title: '我的信息', icon: 'document-text', menuName: '我的信息', right: true},
        component: AppMe
      },
      {
        path: '/add-org',
        name: 'app-create-org-main',
        redirect: '/create/org',
        meta: {title: '创建团队', icon: 'document-text', menuName: '创建团队', right: true},
      }
    ]
  }
];

/**
 * 其他路由
 * @type {[*]}
 */
export const otherRouter = [
  {
    path: '/',
    redirect: '/main',
  },
  {
    path: '/login',
    name: 'app-login',
    meta: {title: '登录'},
    component: Login,
  },
  {
    path: '/create/org',
    name: 'app-create-org',
    meta: {title: '创建组织'},
    component: AddOrg,
  }
];
// 所有上面定义的路由都要写在下面的routers里
export const routers = [
  ...otherRouter,
  ...appMain,
];

