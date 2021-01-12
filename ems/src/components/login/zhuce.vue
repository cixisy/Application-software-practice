<template>
    <div id="login">
        <el-form :model="form" :rules="rules" ref="loginForm" label-width="100px" class="login-box" style="background-color: white">
            <h3 style="font-size: 20px;margin-top: 10px;">欢迎注册</h3>
            <el-form-item label="账号" prop="account">
                <el-input type="text" v-model="form.account" placeholder="请输入编号,只能是数字"></el-input>
            </el-form-item>
            <el-form-item label="姓名" prop="username">
                <el-input type="text" v-model="form.username" placeholder="请输入姓名"></el-input>
            </el-form-item>
			<el-form-item label="性别" prop="sex">

			      <el-radio v-model="form.sex" label="1">男</el-radio>
			      <el-radio v-model="form.sex" label="2">女</el-radio>

			  </el-form-item>
            <el-form-item label="部门" prop="did">
                <el-input type="text" v-model="form.did" placeholder="请输入部门号,只能是数字"></el-input>
            </el-form-item>
			<el-form-item label="上级编号" prop="spid">
			    <el-input type="text" v-model="form.spid" placeholder="请输入上级编号,只能是数字"></el-input>
			</el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input v-model="form.password" type="password"     placeholder="请输入密码"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('loginForm')">注册</el-button>
            </el-form-item>
        </el-form>
        <el-dialog
                title="温馨提示"
                v-model="dialogVisible"
                width="30%"
        >
            <span>请将信息填写完整</span>
            <span  class="dialog-footer">
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
        </el-dialog>
    </div>


</template>

<script>

    export default {
        name: "zhuce",
        data() {
            return {
                flag: 1,
                form: {
                    username: '',
                    account: '',
                    password: '',
                    did: '',
                    spid: '',
                    radio: '1',
					sex:'1'
                },
                rules: {
                    account: [
                        {required: true, message: '请输入账号', trigger: 'blur'},
                    ],
                    password: [
                        {required: true, message: '请输入密码', trigger: 'blur'},
                    ],
                    username: [
                        {required: true, message: '请输入姓名', trigger: 'blur'},
                    ],
                    did: [
                        {required: true, message: '请输入部门', trigger: 'blur'},
                    ],
                    spid: [
                        {required: true, message: '请输入上级编号', trigger: 'blur'},
                    ]
                },
                dialogVisible: false
            };
        },
        methods: {
            onSubmit(formName) {
				console.log("进入注册")
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        if (this.form.radio == 1) {
                            this.$http.get("http://localhost:8081/ems/employee/zhuce?account=" + this.form.account + "&name=" + this.form.username + "&pwd="
							+ this.form.password + "&sex=" + this.form.sex + "&spNum=" + this.form.spid + "&dNum=" + this.form.did).then((res) => {
                                if (res.data != 0) {
                                    alert("注册成功！");
                                    this.$router.push({name: 'Homepage', params: {id: res.data}});
                                } else {
                                    alert("注册失败，输入类型不符或账号已存在");
                                    this.$router.go(0);
                                }
                            })


                        }

                    } else {
                        console.log('error submit!!');
                        this.dialogVisible = true;
                        return false;
                    }
                });
           },

        }
    }
</script>

<style scoped>

    .login-box {
        border: 1px solid black;
        width: 350px;
        margin: 180px auto;
        padding: 35px 35px 15px 15px;
    }
</style>
