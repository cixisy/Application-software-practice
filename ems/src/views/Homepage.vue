<template>
    <el-row class="tac">
        <el-col :span="4">
            <h5>员工管理系统</h5>
            <el-menu
                    :uniqueOpened="true"
                    default-active="2"
                    class="el-menu-vertical-demo"
                    @open="handleOpen"
                    @close="handleClose"
                    background-color="#545c64"
                    text-color="#fff"
                    active-text-color="#ffd04b">
                <el-menu-item index="1">
                    <i class="el-icon-menu"></i>
                    <template #title>主页</template>
                </el-menu-item>



                <el-submenu index="2">
                    <template #title>
                        <i class="el-icon-location"></i>
                        <span>请假</span>
                    </template>
                    <el-menu-item-group>
                        <template #title>分组一</template>
                        <el-menu-item index="2-1">请假申请</el-menu-item>
                        <el-menu-item index="2-2" router-link = ''>审核状态</el-menu-item>
                    </el-menu-item-group>
                    <el-menu-item-group title="分组2">
                        <el-menu-item index="2-3">历史信息</el-menu-item>
                    </el-menu-item-group>
                </el-submenu>

                <el-submenu index="3">
                    <template #title>
                        <i class="el-icon-location"></i>
                        <span>加班</span>
                    </template>
                    <el-menu-item-group>
                        <template #title>分组一</template>
                        <el-menu-item index="3-1">
                            <router-link :to="{path: '/WorkOvertimeApply'}">
                                加班申请
                            </router-link>
                            </el-menu-item>
                        <el-menu-item index="3-2">
                            <router-link :to="{path: '/WorkOvertimeAuditStatus'}" >
                                审核状态
                            </router-link>
                            </el-menu-item>
                    </el-menu-item-group>
                    <el-menu-item-group title="分组2">
                        <el-menu-item index="3-3">
                            <router-link :to="{path: '/WorkOvertimeHistory'}">
                                历史信息
                            </router-link>
                            </el-menu-item>
                    </el-menu-item-group>
                </el-submenu>

                <el-submenu index="4">
                    <template #title>
                        <i class="el-icon-location"></i>
                        <span>审批</span>
                    </template>
                    <el-menu-item-group>
                        <template #title>分组一</template>
                        <el-menu-item index="4-1">请假审批</el-menu-item>
                        <el-menu-item index="4-2">
                            <router-link :to="{path: '/Confirm'}">
                                加班审批
                            </router-link></el-menu-item>
                    </el-menu-item-group>
                </el-submenu>

                <el-menu-item index="5">
                    <i class="el-icon-setting"></i>
                    <template #title>设置</template>
                </el-menu-item>


            </el-menu>
        </el-col>
        <el-main>
            <router-view></router-view>
        </el-main>
    </el-row>


</template>

<script>
    export default {
        name: "Homepage",
        methods: {
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            }
        }
    }
</script>

<style scoped>
    a{
        color: white;
        text-decoration: none;

    }
    .router-link-active {
        text-decoration: none;
        color: #e2a714;
    }
</style>
