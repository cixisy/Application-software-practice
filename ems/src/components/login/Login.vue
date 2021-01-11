<template>
    <div id="login" >
        <el-form :model="form" :rules="rules" ref="loginForm" label-width="100px" class="login-box" style="background-color: white">
            <h3 style="font-size: 20px">欢迎登陆</h3>
            <el-form-item label="账号" prop="account">
                <el-input type="text" v-model="form.account" placeholder="请输入账号,只能是数字"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input v-model="form.password" type="password" placeholder="请输入密码"></el-input>
            </el-form-item>
            <el-form-item>
                <el-radio v-model="form.radio" label="1">员工</el-radio>
                <el-radio v-model="form.radio" label="2">管理员</el-radio>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('loginForm')">登录</el-button>
                <el-button @click="zhuceForm">注册</el-button>
            </el-form-item>
        </el-form>
        <el-dialog
                title="温馨提示"
                v-model="dialogVisible"
                width="30%"
        >
            <span>请输入账号和密码</span>
            <span  class="dialog-footer">
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
        </el-dialog>
    </div>


</template>

<script>
    export default {
        name: "Login",
        data() {
            return {
                form: {
                    account: '',
                    password: '',
                    radio: '1'
                },
                rules: {
                    account: [
                        { required: true, message: '请输入账号,只能是数字', trigger: 'blur' },
                    ],
                    password: [
                        { required: true, message: '请输入密码', trigger: 'blur' },
                    ],
                },
                dialogVisible:false
            };
        },
        methods: {
            onSubmit(formName) {
				console.log("进入login");
                // const  that = this;
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        if (this.form.radio=='2')
                        {
                            this.$http.get("http://localhost:8081/ems/admin/login?account="+this.form.account+"&password="+this.form.password).then((res)=>{
                                if (res.data!=0){
                                    this.$router.push({name:'Homepage',params:{id:res.data,flag:1}});
                                }
                                else {
                                    alert("账号或密码错误");
                                }
                            })
                        }
                        else{
                            this.$http.get("http://localhost:8081/ems/employee/login?account="+this.form.account+"&password="+this.form.password).then((res)=>{
                                if (res.data!=0){
                                    this.$router.push({name:'Homepage',params:{id:res.data,flag:0}})
                                }
                                else {
                                    alert("账号或密码错误");
                                }
                            })
                        }

                    } else {
                        alert('error submit!!');
                        this.dialogVisible = true;
                        return false;
                    }
                });
            },
            zhuceForm(formName) {
                this.$router.push('/zhuce');
            }
        }
    }
</script>

<style scoped>

    .login-box{
        border: 1px solid black;
        width: 350px;
        margin: 180px auto;
        padding: 35px 35px 15px 15px;
    }
    .background{
        width:100%;
        height:100%;  /**宽高100%是为了图片铺满屏幕 */
        z-index:-1;
        position: absolute;
    }

    .front{
        z-index:1;
        position: absolute;
    }
    #building {
        background: url("../../assets/save.jpg");
        width: 100%;
        height: 100%;
        position: fixed;
        background-size: 100% 100%;
    }
</style>
