import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import Home from '../views/Home.vue'
import HomePage from '../views/HomePage.vue'
import Homepage from "@/views/Homepage.vue";
import WorkOvertimeApply from '../components/work_overtime/WorkOvertimeApply.vue'
import WorkOvertimeAuditStatus from '../components/work_overtime/WorkOvertimeAuditStatus.vue'
import WorkOvertimeHistory from '../components/work_overtime/WorkOvertimeHistory.vue'
import Confirm from '../components/work_overtime/Confirm.vue'
import ConfirmTable from '../components/work_overtime/ConfirmTable.vue'
const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'Homepage',
    component: Homepage,
    children: [ {path: '/WorkOvertimeApply', name: 'WorkOvertimeApply', component: WorkOvertimeApply},
                {path: '/WorkOvertimeAuditStatus', name: 'WorkOvertimeAuditStatus', component: WorkOvertimeAuditStatus},
                {path: '/WorkOvertimeHistory', name: 'WorkOvertimeHistory', component: WorkOvertimeHistory},
                {path: '/Confirm', name: 'Confirm', component: Confirm},
                {path: '/ConfirmTable', name: 'ConfirmTable', component: ConfirmTable}
    ]
  },


  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
