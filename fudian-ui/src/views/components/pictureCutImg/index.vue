<template>
  <div style="height: 100%;width: 100%;">
    <vue-picture-cut
      ref="pictureCut"
      :src="src"
      :rotate-control="rotateControl"
    />
  </div>

</template>

<script>
import { VuePictureCut } from 'vue-picture-cut';

export default {
  name:'pictureCutImg',
  // ...
  components: {
    VuePictureCut
  },
  data () {
    return {
      src: 'https://p1-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/c1d7a1feb60346449c1a64893888989a~tplv-k3u1fbpfcp-watermark.image',
      blob: null,
      base64: null,
      // initAngle:1,
 rotateControl:true,
    }
  },
  methods: {
    inputChange(e) {
      const file = e.target.files[0];
      this.src = URL.createObjectURL(file);
    },
    /**
     * @param blob      BLOB对象
     * @param base64    base64字符串
     */
    cutChange({ blob, base64 }) {
      this.blob = blob;
      this.base64 = base64;
    }
  }

}
</script>


<style scoped lang="scss">
@import "~vue-picture-cut/lib/vue-picture-cut.css";
</style>
