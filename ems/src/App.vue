<template>
    <div id="app">
        <router-view></router-view>
    </div>
</template>

<script>


    export default {
        name: 'app',
        components: {},
    }
</script>

<style>
    #app {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #030202;
        background: url("./assets/save2.jpg");
        width: 100%;
        height: 100%;
        position: fixed;
        background-size: 100% 100%;
    }
</style>
