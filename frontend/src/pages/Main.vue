<template>
  <div class="container h-100">
      <div class="row d-flex justify-content-center align-items-center h-100 ">
        <div class="col-7">
            <h1 class="text-center align-middle">로고와 이미지가 들어갈 자리</h1>
        </div>
        <div class="col-5 ">
            <login v-if="login"
            @change="change"
            class=""
            ></login>
            <signup v-if="signup"
            @change="change"
            class=""
            >
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