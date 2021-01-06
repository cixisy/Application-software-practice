<template>
    <div style="width: 1200px;">
    <el-space wrap>
            <el-card class="box-card" v-for="index in 10" :key="index" style="width: 300px;margin-right: 50px">
                <template #header>
                    <div class="clearfix">
                        <span style="font-size: 20px; text-align: left" >编号:{{test.id}}</span>
                        <el-button style="float: right; padding: 3px 0" type="text" @click="modify(index)">修改</el-button>
                    </div>
                </template>
                <div  class="text item" style="text-align: left">
                   姓名: {{test.name}}
                </div>
                <div  class="text item" style="text-align: left">
                    部门: {{test.did}}
                </div>
                <div  class="text item" style="text-align: left">
                   密码: {{test.password}}
                </div>
                <div  class="text item" style="text-align: left">
                   性别: {{test.sex}}
                </div>
            </el-card>
    </el-space>
    </div>
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
                <el-input v-model="form.id"></el-input>
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

</template>

<script lang="js">
    import {defineComponent, reactive} from 'vue'

    export default defineComponent({
        name: "Set",
        setup(){
            const test = reactive({
                name:"王小虎",
                id:123,
                did:"AAA",
                password:"wangxiaohu123",
                sex:'男'
            })

            return{
                test
            }
        },
        data(){
            return {
                dialogVisible:false,
                index:0,
                form: {
                    id:1,
                    name: '',
                    pid:1,
                    password:''
                }
            };
        },
        methods: {
            modify(index) {
                this.dialogVisible = true;
                this.index = index

            },
            confirm(){
                console.log(this.index)
                this.dialogVisible = false
            }
    }

    })

</script>

<style scoped>
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
