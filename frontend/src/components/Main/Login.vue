<template>
  <!-- login box start -->
    <div id="first">
      <div class="myform form ">
        <div class="logo mb-3">
          <div class="col-md-12 text-center">
          <h1>Login</h1>
          </div>
        </div>
        <form action="#" method="post" name="login">
          <div class="form-group">
          <label for="exampleInputEmail1">Email</label>
          <input type="email" name="email" v-validate="'required|email'" v-model="credential.email" data-vv-as="Email"
          class="form-control" :class="{error: errors.has('email')}"  id="email" aria-describedby="emailHelp" placeholder="Enter email">
          <span class="error" v-if="errors.has('email')">{{errors.first('email')}}</span>
        </div>
        <div class="form-group">
          <label for="">Password</label>
          <input type="password" ref="password" name="password" v-validate="'required|min:6'" v-model="credential.password" data-vv-as="Password"
          class="form-control" :class="{error: errors.has('password')}"  id="password" aria-describedby="password" placeholder="Enter Password">
          <span class="error" v-if="errors.has('password')">{{errors.first('password')}}</span>
        </div>
          <!-- <div class="form-group">
            <p class="text-center">By signing up you accept our <a href="#">Terms Of Use</a></p>
          </div> -->
          <div class="col-md-12 text-center ">
            <button type="submit" class=" btn btn-block mybtn btn-primary tx-tfm" @click.prevent="getJWT">Login</button>
          </div>
          <!-- <div class="col-md-12 ">
            <div class="login-or">
                <hr class="hr-or">
                <span class="span-or">or</span>
            </div>
          </div> -->
          <!-- <div class="col-md-12 mb-3">
            <p class="text-center">
                <a href="javascript:void();" class="google btn mybtn"><i class="fa fa-google-plus">
                </i> Signup using Google
                </a>
            </p>
          </div> -->
          <div class="form-group">
            <p class="text-center">Don't have account? <a href="#" id="signup" @click="change">Sign up here</a></p>
          </div>
        </form>        
      </div>
    </div>
    <!-- login box end -->
</template>

<script>
import Vue from 'vue'

import * as VeeValidate from 'vee-validate';
import ko from 'vee-validate/dist/locale/ko.js'
import axios from 'axios';

ko.messages.email = (field) => `${field}은/는 올바른 이메일 형식이어야 합니다.`
ko.messages.required = (field) => `${field}이/가 필요합니다.`

ko.messages.password = (field) => `${field}는 최소 6글자 여야합니다.`

const config = {
  locale: 'ko',
  dictionary: {
    ko
  }
}

Vue.use(VeeValidate, config)

export default {
  name: 'Login',
  data: function () {
    return {
      credential: {
        email: '',
        password: '',
      }
    }
  },
  methods: {
    change: function () {
      this.$emit('change')
    },
    getJWT: function () {
      axios({
        method: 'get',
        url: `http://localhost:8000/api/auth/login`,
        data: this.credential
      })
        .then
    },

    onSubmit() {
      this.$validator.validateAll()

      if (!this.errors.any()) {
        alert('submit!')
      }
    }
  }
}
</script>

<style>
@import url('https://unpkg.com/semantic-ui-css@2.2.9/semantic.css');

span.error {
  color: #9F3A38;
}

</style>