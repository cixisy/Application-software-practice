<template>

    <el-row>
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
                    <template #title>
                        <router-link :to="{path: '/SubHomePage',query:{id:id}}">
                            主页
                        </router-link>
                    </template>
                </el-menu-item>


                <el-submenu index="2">
                <template #title>
                    <i class="el-icon-menu"></i>
                    <span>请假</span>
                </template>
                <el-menu-item-group>
                    <template #title>分组一</template>
                    <el-menu-item index="2-1">
                        <router-link :to="{path:'/leaveapply',query:{id:id}}" background="red">申请请假</router-link>
                    </el-menu-item>
                    <el-menu-item index="2-2">
                        <router-link :to="{path:'/leavestate',query:{id:id}}">审核状态</router-link>
                    </el-menu-item>
                    <el-menu-item index="2-3">
                        <router-link :to="{path:'/leavehistory',query:{id:id}}">历史信息</router-link>
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
                            <router-link :to="{path: '/WorkOvertimeApply',query:{id:id}}">
                                加班申请
                            </router-link>
                        </el-menu-item>
                        <el-menu-item index="3-2">
                            <router-link :to="{path: '/WorkOvertimeAuditStatus',query:{id:id}}">
                                审核状态
                            </router-link>
                        </el-menu-item>
                    </el-menu-item-group>
                    <el-menu-item-group title="分组2">
                        <el-menu-item index="3-3">
                            <router-link :to="{path: '/WorkOvertimeHistory',query:{id:id}}">
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
                        <el-menu-item index="4-1">
                            <router-link :to="{path:'/leavecheck',query:{id:id}}">请假审批</router-link>
                        </el-menu-item>
                        <el-menu-item index="4-2">
                            <router-link :to="{path: '/Confirm',query:{id:id}}">
                                加班审批
                            </router-link>
                        </el-menu-item>
                    </el-menu-item-group>
                </el-submenu>

                <el-menu-item index="5" v-if="flag==='1'">
                    <i class="el-icon-setting"></i>
                    <router-link :to="{path:'/set'}">设置</router-link>
                </el-menu-item>
                <el-button :type="typecolor" @click="checkup()" circle style="width:100px;height:100px;"
                           :disabled="isdisable">上班打卡
                </el-button>
                <br>
                <el-button :type="typecolor1" @click="checkup1()" circle style="width:100px;height:100px;"
                           :disabled="isdisable1">下班打卡
                </el-button>
                <br>

            </el-menu>
        </el-col>

        <el-main>
            <router-view></router-view>
        </el-main>

    </el-row>


</template>

<script>
    /* eslint-disable */
    import {defineComponent, h} from 'vue'
    import {ElMessage} from 'element-plus'
    import moment from "moment"

    export default defineComponent({
        name: "Homepage",
        data() {
            return {

                id: '',
                flag:'0',
                imgSrc: require('../assets/save.jpg'),
                Cwa :{
                    epnum:20210000,
                    ename:'',
                    work_date:'2021-11-1 00:00:00',
                    work_start:'2021-11-1 00:00:00',
                    work_end: '2021-11-1 00:00:00',
                    work_descrip:''
                },
                typecolor: "info",
                typecolor1: "info",
                isdisable: true,
                isdisable1: true,
                checktable: [
                    {
                        epnum: 66666,
                        ename: '陈项',
                        workdate: '',
                        workstartdatetime: '',
                        workenddatetime: '',
                        workdescriptext: '',
                    }
                ]
            }
        },
        beforeRouteEnter: (to, from, next) => {
            next(vm => {
                vm.getParams();

            });

        },
        methods: {
            predo(){
                let timestamp0 = moment(new Date()).format("YYYY-MM-DD")+" 08:00:00";
                let timestamp1 = moment(new Date()).format("YYYY-MM-DD")+" 08:30:00";
                let timestamp2 = new Date(timestamp0).getTime();
                let timestamp3 = new Date(timestamp1).getTime();
                let timestamp4 = new Date().getTime();
               /* typecolor: "primary",
                    typecolor1: "primary",
                    isdisable: false,
                    isdisable1: false,*/
                console.log(moment(new Date()).format("YYYY-MM-DD HH:mm:ss"))
                if(timestamp2<=timestamp4 & timestamp4<=timestamp3){
                    this.typecolor = 'primary';
                    this.isdisable= false;
                }else{
                    this.typecolor = 'info';
                    this.isdisable= true;
                }
                console.log(timestamp2)
                console.log(timestamp3)
                console.log(timestamp4)
            },
            predo1(){
                let timestamp0 = moment(new Date()).format("YYYY-MM-DD")+" 18:00:00";
                let timestamp1 = moment(new Date()).format("YYYY-MM-DD")+" 18:30:00";
                let timestamp2 = new Date(timestamp0).getTime();
                let timestamp3 = new Date(timestamp1).getTime();
                let timestamp4 = new Date().getTime();
                /* typecolor: "primary",
                     typecolor1: "primary",
                     isdisable: false,
                     isdisable1: false,*/
                if(timestamp2<=timestamp4 & timestamp4<=timestamp3){
                    this.typecolor1 = 'primary';
                    this.isdisable1= false;
                }else{
                    this.typecolor1 = 'info';
                    this.isdisable1= true;
                }
                console.log(timestamp2)
                console.log(timestamp3)
                console.log(timestamp4)
            },
            getParams() {
                this.id = this.$route.params.id;
                this.flag = this.$route.params.flag;
                console.log(this.flag);
                this.$router.push({path:'/SubHomePage',query:{id:this.id}})
                this.Cwa.epnum =this.id;
                this.predo()
                this.predo1()

                this.Cwa.work_date = moment(new Date()).format("YYYY-MM-DD");
                console.log(this.Cwa)
                this.axios({
                    method:'post',
                    url:"http://localhost:8081/ems/employee/saveCwa",
                    data:this.Cwa,

                }).then((res)=>{
                    console.log( '打卡日期更新成功')

                    /*
                        typecolor1: "info",
                        isdisable: false,
                        isdisable1: true,*/
                });


            },
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            },
            checkup(){
                console.log(this.Cwa)
                this.Cwa.work_date = moment(new Date()).format("YYYY-MM-DD");
                this.Cwa.work_start = moment(new Date()).format("YYYY-MM-DD HH:mm:ss");

                this.axios({
                    method:'post',
                    url:"http://localhost:8081/ems/employee/updateCwa",
                    data:this.Cwa,

                }).then(()=>{

                    console.log( '打卡成功')
                    this.typecolor ="primary"
                    this.isdisable = true
                });

            },
            checkup1(){
                console.log(this.Cwa)
                this.Cwa.work_date = moment(new Date()).format("YYYY-MM-DD");
                this.Cwa.work_end = moment(new Date()).format("YYYY-MM-DD HH:mm:ss");

                this.axios({
                    method:'post',
                    url:"http://localhost:8081/ems/employee/updateCwaend",
                    data:this.Cwa,

                }).then(()=>{

                    console.log( '打卡成功')
                    this.typecolor ="primary"
                    this.isdisable = true
                });

            }
        },

       /* created() {
            this.$router.push({path:'/SubHomePage',query:{id:this.id}})
        },*/
        setup() {
            return {
                open() {
                    console.log(this.Cwa)



                },
                openVn() {
                    ElMessage({
                        message: h('p', null, [
                            h('span', null, '内容可以是 '),
                            h('i', {style: 'color: teal'}, 'VNode')
                        ])
                    });
                }
            }
        }
    })
</script>

<style scoped>
    a {
        color: white;
        text-decoration: none;

    }
    .text {
        font-size: 14px;
    }

    .item {
        margin-bottom: 18px;
    }

    .clearfix:before,
    .clearfix:after {
        display: table;
        content: "";
    }

    .clearfix:after {
        clear: both
    }

    .box-card {
        width: 480px;
    }


</style>
