<template>

    <div style = 'width:1200px'>
        <el-row >
           <!-- 资料卡片-->
            <el-col :span="4" class="ant-form-item-label">
                <el-card  >
                    <template #header>
                        <div >
                            <span>资料</span>
                        </div>
                    </template>
                    <div>
                       工号: {{emploeeInfo.epnum}}<br>
                       姓名 :{{emploeeInfo.ename}}<br>
                       性别 :{{emploeeInfo.sex}}<br>
                        部门 :{{emploeeInfo.depnum}}<br><br>
                        <el-button type="primary" round class="button1" size="mini">安全隐私</el-button>
                    </div>
                </el-card>
            </el-col>
            <!--通知信息栏-->
            <el-col :span="12">
                <el-container style="{width:100%}"  class="ant-form-item-label">
                    <el-header>通知:</el-header>
                    <el-main>
                        <span>头上一片晴天，心中一个想念</span>
                        <el-divider></el-divider>
                        <span>饿了别叫妈, 叫饿了么</span>
                        <el-divider></el-divider>
                        <span>为了无法计算的价值</span>
                        <el-divider ></el-divider>
                    </el-main>
                </el-container>
            </el-col>
            <!--日历-->
            <el-col :span="8">
                <el-calendar v-model="value">
                </el-calendar>
            </el-col>
        </el-row>


    </div>
</template>

<script>

    export default {
        name: "SubHomePage",
        data() {
            return {
                emploeeInfo:{
                    epnum:66666,
                    ename: '陈项',
                    pwd:'',
                    sex:0,
                    superiorepnum : 123456,
                    depnum: 111,
                    superiormark:0

                },
                value: new Date(),
                imgSrc:require('../assets/save.jpg')
            }
            }


    }
</script>

<style scoped>
    .ant-form-item-label {
        text-align: left;
    }
    .button1{

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

</style>
