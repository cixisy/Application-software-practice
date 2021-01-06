import {createRouter, createWebHistory, RouteRecordRaw} from 'vue-router'
import Home from '../views/Home.vue'
import HomePage from '../views/HomePage.vue'
import Homepage from "@/views/Homepage.vue";
import WorkOvertimeApply from '../components/work_overtime/WorkOvertimeApply.vue'
import WorkOvertimeAuditStatus from '../components/work_overtime/WorkOvertimeAuditStatus.vue'
import WorkOvertimeHistory from '../components/work_overtime/WorkOvertimeHistory.vue'
import Confirm from '../components/work_overtime/Confirm.vue'
import ConfirmTable from '../components/work_overtime/ConfirmTable.vue'
import SubHomePage from '../components/SubHomePage.vue'


import LeaveApply from "@/components/leave/LeaveApply.vue";
import LeaveState from "@/components/leave/LeaveState.vue";
import LeaveHistory from "@/components/leave/LeaveHistory.vue";
import LeaveDetails from "@/components/leave/LeaveDetails.vue";
import LeaveCheck from "@/components/leave/LeaveCheck.vue";
import Login from "@/components/login/Login.vue"
import zhuce from "@/components/login/zhuce.vue";
import Set from "@/components/Set.vue";


const routes: Array<RouteRecordRaw> = [
    {
        path: '/',
        name: 'login',
        component: Login
    },
    {
        path: '/zhuce',
        name: 'zhuce',
        component: zhuce
    },
    {
        path: '/home',
        name: 'Homepage',
        component: Homepage,
        children: [
            {path: '/WorkOvertimeApply', name: 'WorkOvertimeApply', component: WorkOvertimeApply},
            {path: '/WorkOvertimeAuditStatus', name: 'WorkOvertimeAuditStatus', component: WorkOvertimeAuditStatus},
            {path: '/WorkOvertimeHistory', name: 'WorkOvertimeHistory', component: WorkOvertimeHistory},
            {path: '/Confirm', name: 'Confirm', component: Confirm},
            {path: '/ConfirmTable', name: 'ConfirmTable', component: ConfirmTable},
            {path: '/SubHomePage', name: 'SubHOmePage', component: SubHomePage},
            {path: '/leaveapply', name: 'leavename', component: LeaveApply},
            {path: '/leavestate', name: 'leavestate', component: LeaveState},
            {path: '/leavehistory', name: 'leavehistory', component: LeaveHistory},
            {path: '/leavedetails', name: 'leavedetails', component: LeaveDetails},
            {path: '/leavecheck', name: 'leavecheck', component: LeaveCheck},
            {path: '/set', name: 'set', component: Set}
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
