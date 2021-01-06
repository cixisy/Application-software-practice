<template>

    <el-row >
        <el-col :span="4">

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
                    <template #title><router-link :to="{path: '/SubHomePage'}">
                        主页
                    </router-link></template>
                </el-menu-item>



                <el-submenu index="2">
                    <template #title>
                        <i class="el-icon-menu"></i>
                        <span>请假</span>
                    </template>
                    <el-menu-item-group>
                        <template #title>分组一</template>
                        <el-menu-item index="2-1">
                            <router-link :to="{path:'/leaveapply'}" background="red">申请请假</router-link>
                        </el-menu-item>
                        <el-menu-item index="2-2">
                            <router-link :to="{path:'/leavestate'}">审核状态</router-link>
                        </el-menu-item>
                        <el-menu-item index="2-3">
                            <router-link :to="{path:'/leavehistory'}">历史信息</router-link>
                        </el-menu-item>
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
                        <el-menu-item index="4-1" >
                            <router-link :to="{path:'/leavecheck'}">请假审批</router-link>
                        </el-menu-item>
                        <el-menu-item index="4-2">
                            <router-link :to="{path: '/Confirm'}">
                                加班审批
                            </router-link></el-menu-item>
                    </el-menu-item-group>
                </el-submenu>

                <el-menu-item index="5">
                    <i class="el-icon-setting"></i>
                    <router-link :to="{path:'/set'}">设置</router-link>
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
        data(){
            return {
                imgSrc:require('../assets/save.jpg')
            }
        },
        methods: {
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            }
        },
        created() {
            this.$router.push('SubHomePage')
        },
    }
</script>

<style scoped>
    a{
        color: white;
        text-decoration: none;

    }


</style>
