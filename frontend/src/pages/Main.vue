<template>
  <div class="container" style="">
      <div class="row">
        <div class="col-7">
            <h1 class="text-center align-middle">로고와 이미지가 들어갈 자리</h1>
        </div>
        <div class="col-5">
            <login v-if="login"
            @change="change"
            ></login>
            <signup v-if="signup"
            @change="change">
            </signup>
        </div>
      </div>
      
  </div>
</template>

<script>
import Login from 'src/components/Main/Login.vue'
import Signup from 'src/components/Main/Signup.vue'

export default {
    components: {
        Login,
        Signup
    },
    data () {
        return {
            login: true,
            signup: false
        }
    },
    methods : {
        change() {
            this.login = !this.login
            this.signup = !this.signup
        }
    }
}
</script>
<style>

</style>