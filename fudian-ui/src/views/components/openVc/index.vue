<template>

  <div>
    <div style="height: 500px;width: 100%;display: flex">
      <div style="height: 400px;width: 400px;background-color: wheat;border: 1px solid antiquewhite" ref="openDiv">
<!--        <img src="../../../assets/images/image.jpg" alt="" style="height: 100%;width: 100%;object-fit: contain" id="openImg">-->
                <img src="../../../assets/images/bg1.jpg" alt="" style="height: 100%;width: 100%;object-fit: contain" id="openImg">
      </div>
      <canvas id="dstImg" style="height: 400px;width: 400px;background-color: wheat;border: 1px solid antiquewhite;margin-left: 10px;"></canvas>
    </div>

    <el-button @click="handleClick">处理</el-button>
  </div>

</template>
<script>
import cv from "opencv4js";

export default {
  name: 'OpenVc',
  methods: {
    handleClick() {
      let imgElement = document.getElementById("openImg");
      let src = cv.imread(imgElement);
     //  console.log('cv', src)
      let dst = new cv.Mat();
    cv.cvtColor(src, dst, cv.COLOR_BGR2GRAY, 0); // 转灰度


      cv.imshow('dstImg', dst);
      src.delete();
      dst.delete();

    },
    getSortedVertex(points) {
      const center = {
        x: points.reduce((sum, p) => sum + p.x, 0) / 4,
        y: points.reduce((sum, p) => sum + p.y, 0) / 4
      }
      let sortedPoints = []
      sortedPoints.push(points.find(p => p.x < center.x && p.y < center.y))
      sortedPoints.push(points.find(p => p.x > center.x && p.y < center.y))
      sortedPoints.push(points.find(p => p.x > center.x && p.y > center.y))
      sortedPoints.push(points.find(p => p.x < center.x && p.y > center.y))
      return sortedPoints
    },
  }
}

</script>

<style lang="scss" scoped>
</style>
