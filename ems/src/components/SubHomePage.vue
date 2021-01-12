<template>

    <div style='width:1200px'>
        <el-row>
            <!-- 资料卡片-->
            <el-col :span="4" class="ant-form-item-label">
                <el-card>
                    <template #header>
                        <div>
                            <span>资料</span>
                        </div>
                    </template>
                    <div>
                        工号: {{emploeeInfo.epnum}}<br>
                        姓名 :{{emploeeInfo.ename}}<br>
                        性别 :{{emploeeInfo.sex}}<br>
                        部门 :{{emploeeInfo.dep_num}}<br><br>
                        <el-button type="primary" round class="button1" @click="modify()" size="mini">安全隐私</el-button>
                    </div>
                </el-card>

            </el-col>

            <!--通知信息栏-->
            <el-col :span="11">
                <el-container style="{width:100%}" class="ant-form-item-label">
                    <el-header>通知:</el-header>
                    <el-main>
                        <span>新年快乐！</span>
                        <el-divider></el-divider>
                        <span>明天放假</span>
                        <el-divider></el-divider>
                        <span>因疫情原因，加班工资升为300每天</span>
                        <el-divider></el-divider>
                    </el-main>
                </el-container>
            </el-col>
            <!--日历-->
            <el-col :span="9">
                <el-calendar v-model="value">
                </el-calendar>
            </el-col>
        </el-row>
        <el-backtop  :bottom="100">
            <div
                    style="{
        height: 100%;
        width: 100%;
        background-color: #f2f5f6;
        box-shadow: 0 0 6px rgba(0,0,0, .12);
        text-align: center;
        line-height: 40px;
        color: #1989fa;
      }"
            >
                UP
            </div>

        </el-backtop>
        <el-dialog title="信息修改" v-model="dialogVisible" width="500px">
            <el-form ref="form" :model="form" label-width="80px">
                <el-form-item label="编号">
                    <el-input v-model="form.id" disabled></el-input>
                </el-form-item>
                <el-form-item label="姓名">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="部门">
                    <el-input v-model="form.pid"></el-input>
                </el-form-item>
                <el-form-item label="密码">
                    <el-input v-model="form.password"></el-input>
                </el-form-item>


            </el-form>
            <span  class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="confirm">确 定</el-button>
      </span>
        </el-dialog>

    </div>

</template>

<script>
    /* eslint-disable */
    export default {
        name: "SubHomePage",
        data() {
            return {
                emploeeInfo: {
                    epnum: 20212000,
                    ename: '陈项',
                    pwd: '',
                    sex: 0,
                    superior_epnum: 202120001,
                    dep_num: 300,
                    superior_mark: 0

                },
                value: new Date(),
                imgSrc: require('../assets/save.jpg'),
                id:'',
                dialogVisible:false,
                index:0,
                form: {
                    id:1,
                    name: '',
                    pid:1,
                    password:'',
                    spNum:'',
                    flag:'0'
                },
                test:[]
            }
        },

        beforeRouteEnter: (to, from, next) => {
            next(vm => {
                vm.getParams();
            });
        },
        methods: {
            getParams() {
                this.id = this.$route.query.id;
                console.log(this.id)

                this.$http.get("http://localhost:8081/ems/employee/queryEmployeeInfoById?id=" + this.id).then((res) => {
                    this.emploeeInfo = res.data;
                    console.log(this.emploeeInfo)
                    if (this.emploeeInfo.sex==0){
                        this.emploeeInfo.sex= '女'
                    }
                    else{
                        this.emploeeInfo.sex='男'
                    }

                })
            },
            modify() {

                this.form.id = this.emploeeInfo.epnum
                this.form.name = this.emploeeInfo.ename
                this.form.pid = this.emploeeInfo.dep_num
                this.form.password = this.emploeeInfo.pwd
                this.form.spNum =this.emploeeInfo.superior_epnum
                this.form.flag = ''+this.emploeeInfo.superior_mark
                this.dialogVisible = true;



            },
            confirm(){
                this.$http.get("http://localhost:8081/ems/employee/updateEmployeeInfoself?nId="+this.form.id
                    +"&nName="+this.form.name+"&ndNum="+this.form.pid+"&nPwd="+this.form.password+"&nsNum="+this.form.spNum+"&nMark="+this.form.flag
                ).then((res)=>{
                   console.log("ok")
                    this.$http.get("http://localhost:8081/ems/employee/queryEmployeeInfoById?id=" + this.id).then((res) => {
                        this.emploeeInfo = res.data;
                        console.log(this.emploeeInfo)
                        if (this.emploeeInfo.sex==0){
                            this.emploeeInfo.sex= '女'
                        }
                        else{
                            this.emploeeInfo.sex='男'
                        }

                    })
                })




                this.dialogVisible = false
            }

        }



    }
</script>

<style scoped>
    .ant-form-item-label {
        text-align: left;
    }

    .button1 {

    }

    .background {
        width: 100%;
        height: 100%; /**宽高100%是为了图片铺满屏幕 */
        z-index: -1;
        position: absolute;
    }

    .front {
        z-index: 1;
        position: absolute;
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
