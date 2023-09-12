<template>
  <div v-if="visible" class="mask vue-img-cutter" ref="mask">
    <transition
      name="fade"
      enter-class="fade-in-enter"
      enter-active-class="fade-in-active"
      leave-class="fade-out-enter"
      leave-active-class="fade-out-active">
      <div
        ref="dialogMainModalRef"
        class="dialogMainModal">
        <div class="toolMain">
          <div class="tool-title">
            图片处理
            <span class="close" @click="handleClose"><i class="el-icon-close"></i></span>
          </div>
          <div class="tool-des">第 <span class="des">{{ currentImg.fileCount }}</span> 件，第
            <span class="des">{{ currentImg.pageCount }}</span> 页
          </div>
          <div style="display: flex;width: 100%;padding-left: 20px">
            <div
              ref="toolBox"
              @mousemove="controlBtnMouseMove"
              @mouseup="controlBtnMouseUp"
              @mouseleave="controlBtnMouseUp"
              class="toolBox">
              <!--裁剪区域-->
              <div
                v-show="drawImg.img != null"
                ref="toolBoxControl"
                @mousedown="toolBoxMouseDown"
                @mouseup="toolBoxMouseUp"
                @mousemove="toolBoxMouseMove"
                @mouseleave="toolBoxMouseLeave"
                class="toolBoxControl"
                style="pointerEvents:auto;"
                :class="{isToolBoxControl:toolBoxControlBoxFlag}">
                <div class="toolBoxControlBox">
                  <div class="controlBox">
                    <!--蚂蚁线-->
                    <div class="controlBoxInnerLine controlBoxInnerLineTop"></div>
                    <div class="controlBoxInnerLine controlBoxInnerLineBottom"></div>
                    <div class="controlBoxInnerLine controlBoxInnerLineLeft"></div>
                    <div class="controlBoxInnerLine controlBoxInnerLineRight"></div>
                    <!--工具栏提示-->
                    <div class="selectArea">
                      宽:{{ showToolBoxWidth }} 高:{{ showToolBoxHeight }} (x:{{
                        showToolBoxX
                      }},y:{{ showToolBoxY }})
                    </div>
                    <!--操作杆-->
                    <div
                      data-name="leftUp"
                      v-if="sizeChange === true"
                      @mousedown="controlBtnMouseDown($event, 'leftUp')"
                      class="leftUp controlBtn"
                    ></div>
                    <div
                      data-name="leftDown"
                      v-if="sizeChange === true"
                      @mousedown="controlBtnMouseDown($event, 'leftDown')"
                      class="leftDown controlBtn"
                    ></div>
                    <div
                      data-name="rightUp"
                      v-if="sizeChange === true"
                      @mousedown="controlBtnMouseDown($event, 'rightUp')"
                      class="rightUp controlBtn"
                    ></div>
                    <div
                      data-name="rightDown"
                      v-if="sizeChange === true"
                      @mousedown="controlBtnMouseDown($event, 'rightDown')"
                      class="rightDown controlBtn"
                    ></div>

                    <div
                      data-name="topCenter"
                      v-if="sizeChange === true && !rate && toolBox.width > 20"
                      @mousedown="controlBtnMouseDown($event, 'topCenter')"
                      class="topCenter controlBtn"
                    ></div>
                    <div
                      data-name="downCenter"
                      v-if="sizeChange === true && !rate && toolBox.width > 20"
                      @mousedown="controlBtnMouseDown($event, 'downCenter')"
                      class="downCenter controlBtn"
                    ></div>
                    <div
                      data-name="leftCenter"
                      v-if="sizeChange === true && !rate && toolBox.height > 20"
                      @mousedown="controlBtnMouseDown($event, 'leftCenter')"
                      class="leftCenter controlBtn"
                    ></div>
                    <div
                      data-name="rightCenter"
                      v-if="sizeChange === true && !rate && toolBox.height > 20"
                      @mousedown="controlBtnMouseDown($event, 'rightCenter')"
                      class="rightCenter controlBtn"
                    ></div>
                  </div>
                  <div class="toolBoxControlLine toolBoxControlLineItem-1"></div>
                  <div class="toolBoxControlLine toolBoxControlLineItem-2"></div>
                  <div class="toolBoxControlLine toolBoxControlLineItem-3"></div>
                  <div class="toolBoxControlLine toolBoxControlLineItem-4"></div>
                </div>
              </div>
              <!--画布-->
              <canvas
                v-show="currentImg.src != null||!currentImg.src"
                class="canvasSelectBox"
                ref="canvasSelectBox"
                :width="boxWidth"
                @mousedown="dropImgOn"
                @mouseup="dropImgOff"
                @mousemove="dropImgMove"
                :height="boxHeight"
              ></canvas>
              <canvas v-show="currentImg.src != null||!currentImg.src" class="canvas" ref="canvas" :width="boxWidth"
                      :height="boxHeight"></canvas>
              <div v-show="!currentImg.src" class="noImg">暂无图片</div>
              <div class="selectBtn" v-if="toolBoxControlBoxFlag===true">
                <div class="el-icon-check" @click="handleSaveCut"></div>
                <div class="el-icon-close" @click="handleCancelCut"></div>
              </div>
            </div>
            <div class="rightDiv">
              <div v-if="currentImg.src != null||currentImg.src" ref="rightDivImg">
                <img :src="downloadImgSrc" :alt='currentImg.name'/>
              </div>
              <div v-show="!currentImg.src">暂无图片</div>
              <p>图片预览</p>
            </div>
          </div>
          <div
            class="dockMain">
            <div style="height: 30px;">
              <div class="dockBtn">旋转</div>
              <div class="dockBtnScrollBar">
                <div
                  ref="dockBtnScrollControl"
                  @mousemove="scrollBarControlMove"
                  @mousedown="scrollBarControlOn"
                  @mouseleave="scrollBarControlOff"
                  @mouseup="scrollBarControlOff"
                  :style="'left:' + rotateControl.position + 'px'"
                  class="scrollBarControl"
                ></div>
                <div
                  class="scrollBarText"
                  :style="'left:' + rotateControl.position + 'px'"
                >
                  {{ rotateImg.angle.toFixed(0) + '°' }}
                </div>
              </div>
            </div>
            <div>
              <div @click="handleCut" class="dockBtn">裁剪</div>
              <div @click="handleScale(-3)" class="dockBtn">放大</div>
              <div @click="handleScale(3)" class="dockBtn">缩小</div>
              <div @click="flipHorizontal" class="dockBtn">
                <slot name="flipHorizontal"> 左右翻转</slot>
              </div>
              <div @click="flipVertically" class="dockBtn">
                <slot name="flipVertically"> 上下翻转</slot>
              </div>
              <div @click="turnReset()" class="dockBtn">
                <slot name="reset"> 还原</slot>
              </div>
              <div @click="previousPage(currentImg)" class="dockBtn">上一页</div>
              <div @click="nextPage(currentImg)" class="dockBtn">下一页</div>
              <div @click="imgMoveUp(currentImg)" class="dockBtn">上移</div>
              <div @click="imgMoveDown(currentImg)" class="dockBtn">下移</div>
              <div @click="chooseImg(currentImg)" class="dockBtn">替换</div>
              <a
                :class="'dockBtn btn-light' + (downloadImgSrc ? '' : ' disabled')"
                :disabled="!downloadImgSrc"
                :href="downloadImgSrc"
                :download="fileName || 'image.jpg'"
                role="button"
              >下载</a>
              <div @click="savePicture" class="dockBtn">保存</div>
            </div>
          </div>
        </div>

        <div class="i-dialog-footer">
          <input
            @change="putImgToCanv"
            ref="inputFile"
            type="file"
            accept="image/gif, image/jpeg ,image/png"
            style="width: 1px; height: 1px; border: none; opacity: 0"
          />
          <div class="btn-group fr">
            <span @click="handleClose">
              <slot name="cancel">
                <el-button size="mini" style="margin-right: 10px;">取消</el-button>
              </slot>
            </span>
            <span>
              <slot name="confirm">
                <el-button type="primary" :disabled="!drawImg.img" style="margin-right: 10px;" size="mini"
                           @click="handleNextPiece(currentImg)">下一件</el-button>
              </slot>
            </span>
          </div>
        </div>
      </div>
    </transition>
  </div>
</template>
<script>

export default {
  name: 'ImgCutter',
  props: {
    // 下载地址
    downloadImgSrc: {
      type: String,
      default: '',
      required: false,
    },
    // 下载名称
    fileName: {
      type: String,
      default: '',
      required: false,
    },
    // 是否设置图片跨域
    crossOrigin: {
      type: Boolean,
      default: false,
      required: false,
    },
    // 是否设置图片跨域
    crossOriginHeader: {
      type: String,
      default: '*',
      required: false,
    },
    // 是否在弹窗出现时锁定body
    lockScroll: {
      type: Boolean,
      default: true,
      required: false,
    },
    // 是否显示选择图片按钮 如果需要兼容IE9 则将此参数改为false
    showChooseBtn: {
      type: Boolean,
      default: true,
      required: false,
    },
    // 按比例裁剪
    rate: {
      type: String,
      default: null,
      required: false,
    },
    // 能否调整裁剪尺寸
    sizeChange: {
      type: Boolean,
      default: true,
      required: false,
    },
    // 是否为原图裁剪
    originalGraph: {
      type: Boolean,
      default: false,
      required: false,
    },
    // 能否调整裁剪区域位置
    moveAble: {
      type: Boolean,
      default: true,
      required: false,
    },
    // 裁剪过程中是否返回裁剪结果 裁剪原图卡顿时将此项设置为false
    previewMode: {
      type: Boolean,
      default: true,
      required: false,
    },
    // 是否裁剪原图
    CuttingOriginal: {
      type: Boolean,
      default: false,
      required: false,
    },
    // 选择的图片宽高均小于裁剪宽高度时候直接上传原图
    smallToUpload: {
      type: Boolean,
      default: false,
      required: false,
    },
    // 是否保存上一次裁剪位置
    saveCutPosition: {
      type: Boolean,
      default: false,
      required: false,
    },
    // 是否允许缩放图片
    scaleAble: {
      type: Boolean,
      default: true,
      required: false,
    },
    // 文件类型
    fileType: {
      default: 'png',
      required: false,
      type: String,
    },
    // 是否允许裁剪框超出图片
    toolBoxOverflow: {
      type: Boolean,
      default: true,
      required: false,
    },
    DoNotDisplayCopyright: {
      type: Boolean,
      default: false,
      required: false,
    },
    // 裁剪后的图片质量
    quality: {
      type: Number,
      default: 1,
      required: false,
    },
    // 当前图片信息
    currentImg: {
      type: Object,
      default: () => {
        return {
          id: '',
          name: '',
          src: '',
          fileCount: null,
          pageCount: null
        }
      }
    },
  },
  model: ['rate', 'tool', 'DoNotDisplayCopyright'],
  data() {
    let toolBoxWidth, toolBoxHeight;
    toolBoxWidth = this.boxWidth / 2;
    toolBoxHeight = this.boxHeight / 2;
    return {
      visible: false,
      boxWidth: '',
      boxHeight: '',
      cutWidth: '',
      cutHeight: '',
      // fileName: '',
      cutImageObj: null,
      onPrintImgTimmer: null,
      toolBoxPosition: {
        x: 0,
        y: 0,
      },
      drawImg: {
        img: null, //规定要使用的图像、画布或视频
        sx: 0, //开始剪切的 x 坐标位置
        sy: 0, //开始剪切的 y 坐标位置
        swidth: 0, //被剪切图像的宽度
        sheight: 0, //被剪切图像的高度
        x: 0, //在画布上放置图像的 x 坐标位置
        y: 0, //在画布上放置图像的 y 坐标位置
        width: 0, //要使用的图像的宽度
        height: 0, //要使用的图像的高度
      },
      toolBox: {
        disable: true,
        width: toolBoxWidth,
        height: toolBoxHeight,
        x: 0,
        y: 0,
        boxMove: {
          start: {
            x: 0,
            y: 0,
          },
          moveTo: {
            x: 0,
            y: 0,
          },
        },
      },
      dropImg: {
        active: false,
        pageX: 0,
        pageY: 0,
        params: {},
      },
      // 旋转
      rotateImg: {
        angle: 0,
      },
      rotateControl: {
        active: false,
        start: {
          x: 0,
          y: 0,
        },
        position: 100,
      },
      // 缩放
      scaleImg: {
        rate: 0,
        params: {},
      },
      controlBox: {
        disable: true,
        btnName: '',
        start: {
          x: 0,
          y: 0,
          width: 0,
          height: 0,
        },
      },
      selectBox: false,
      selectBoxColor: 'rgba(0,0,0,0.1)',
      isFlipHorizontal: false, //是否水平翻转
      isFlipVertically: false, // 是否垂直翻转
      imgMove: true,    // 能否拖动图片
      toolBoxControlBoxFlag: false,  //是否显示裁剪框
      currentLeft: 0,  //当前裁剪框左边距
      currentTop: 0,   //当前裁剪框上边距
    };
  },

  computed: {

    showToolBoxWidth() {
      let result;
      if (!this.originalGraph) {
        result = this.toolBox.width;
      } else {
        result = this.toolBox.width / (this.drawImg.width / this.drawImg.swidth);
      }
      return Number(result).toFixed(0);
    },
    showToolBoxHeight() {
      let result;
      if (!this.originalGraph) {
        result = this.toolBox.height;
      } else {
        result = this.toolBox.height / (this.drawImg.width / this.drawImg.swidth);
      }
      return Number(result).toFixed(0);
    },
    showToolBoxX() {
      let result;
      result = this.toolBoxPosition.x;
      return Number(result).toFixed(0);
    },
    showToolBoxY() {
      let result;
      result = this.toolBoxPosition.y;
      return Number(result).toFixed(0);
    },
    // fileType() {
    //   let index = this.fileName.lastIndexOf('.');
    //   return this.fileName.slice(index + 1)
    // }
  },
  methods: {
    //图像处理弹窗监听键盘回车保存事件
    keyDown() {
      let that = this
      //监听键盘按钮
      document.onkeydown = function (e) {

        let keyCode = e.keyCode || e.which || e.charCode;
        // 右下角保存按钮快捷键（s)
        if (keyCode == 83) {
          that.savePicture();
          e.preventDefault();
          return false;
        }
        // 裁剪快捷键：按c之后，出现可裁剪拖拽区域
        if (keyCode == 67) {
          that.handleCut();
          e.preventDefault();
          return false;
        }
        //   还原快捷键：z
        if (keyCode == 90) {
          that.turnReset();
          e.preventDefault();
          return false;
        }
        //   上一页快捷键：键盘↑
        if (keyCode == 38) {
          that.previousPage(that.currentImg)
          e.preventDefault();
          return false;
        }
        //   下一页快捷键：键盘↓
        if (keyCode == 40) {
          that.nextPage(that.currentImg)
          e.preventDefault();
          return false;
        }
        //   旋转快捷键：按键盘←负数旋转增加1度
        if (keyCode == 37) {
          if (that.rotateImg.angle > -180) {
            that.rotateImg.angle--;
            let turnAngle = that.rotateImg.angle;
            that.rotateControl.position = (turnAngle / 180) * 100 + 100;
            that.printImg('rotate');
          } else {
            return
          }
          e.preventDefault();
          return false;
        }
        //   旋转快捷键：按键盘→正数旋转增加1度
        if (keyCode == 39) {
          if (that.rotateImg.angle <= 179) {
            that.rotateImg.angle++;
            let turnAngle = that.rotateImg.angle;
            that.rotateControl.position = (turnAngle / 180) * 100 + 100;
            that.printImg('rotate');
          } else {
            return
          }
          e.preventDefault();
          return false;
        }
      }
    },
    // 初始化设置
    initialize() {
      let clientWidth = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
      let clientHeight = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;
      this.boxWidth = Number(clientWidth * 0.7 - 80);
      this.boxHeight = Number(clientHeight * 0.9 - 300);
      this.cutWidth = 0;  //裁剪宽度
      this.cutHeight = 0; //裁剪高度
      this.isFlipHorizontal = false;
      this.isFlipVertically = false;
      this.rotateImg.angle = 0;
      this.rotateControl.position = 100;
      if ((!this.currentImg.name) || (!this.currentImg.src)) {
        this.drawImg.img = ''
      }
    },
    // 初始化图片
    handleOpen(img) {
      let init = (callback) => {
        if (this.$refs['toolBox']) {
          this.$refs['toolBox'].onmousewheel = this.scaleImgWheel;
          this.$refs['toolBox'].addEventListener('DOMMouseScroll', this.scaleImgWheel);
        }
        if (callback && typeof callback === 'function') {
          callback();
        }
      };
      let canvasSelectBox = this.$refs.canvasSelectBox;
      let rightDivImg = this.$refs.rightDivImg;
      let canvas = this.$refs.canvas;
      // 如果传入了图片
      if (img && typeof img == 'object' && img.src && img.name) {
        canvasSelectBox.style.display = 'block';
        canvas.style.display = 'block';
        rightDivImg.style.display = 'flex';
        if (img.name) {
          let $image = new Image();
          $image.setAttribute('crossOrigin', 'anonymous') //关键
          if (this.crossOrigin === true) {
            $image.crossOrigin = this.crossOriginHeader;
          }
          $image.name = img.name;
          $image.style.position = 'fixed';
          $image.style.top = -5000 + 'px';
          $image.style.opacity = 0;
          $image.onerror = (e) => {
            this.$emit('error', {
              event: e,
              msg: '图片加载失败',
            });
          };
          $image.onload = () => {
            if ($image.complete === true) {
              this.$nextTick(() => {
                init(() => {
                  this.importImgToCanv($image);
                  this.$emit('onPrintImg', {
                    id: this.currentImg.id,
                    fileName: this.currentImg.name,
                    dataURL: this.currentImg.src
                  });
                });
              });
            } else {
              throw new Error('图片加载失败');
            }
          };
          $image.src = img.src;
          this.cutImageObj = $image;
          document.body.appendChild($image);
          // this.$emit('onChooseImg', img);
        } else {
          throw new Error('传入参数必须包含：src,name');
        }
      } else {
        canvasSelectBox.style.display = 'none';
        canvas.style.display = 'none';
        rightDivImg.style.display = 'none';
        this.$nextTick(() => {
          init();
        });
      }

    },
    // 关闭弹窗
    handleClose() {
      this.visible = false;
      document.onkeydown = null;
    },
    // 将图片填充画布
    importImgToCanv(img) {

      let imgHeight = img.height;

      let imgWidth = img.width;

      let boxWidth = this.boxWidth;

      let boxHeight = this.boxHeight;

      let rate;

      let drawImg = {...this.drawImg};
      drawImg.img = img;
      this.scaleImg.rate = imgWidth / imgHeight; // 缩放时用到此参数
      if (imgHeight < boxHeight && imgWidth < boxWidth) {
        rate = 1;
        drawImg.x = (boxWidth - imgWidth) / 2;
        drawImg.y = (boxHeight - imgHeight) / 2;
      } else {
        if (imgWidth / imgHeight <= boxWidth / boxHeight) {
          // 计算宽高比
          rate = boxHeight / imgHeight;
          drawImg.x = (boxWidth - imgWidth * rate) / 2;
        } else {
          rate = boxWidth / imgWidth;
          drawImg.y = (boxHeight - imgHeight * rate) / 2;
        }
      }
      drawImg.swidth = imgWidth;
      drawImg.sheight = imgHeight;
      drawImg.width = imgWidth * rate;
      drawImg.height = imgHeight * rate;
      drawImg.x = (boxWidth - drawImg.width) / 2;
      drawImg.y = (boxHeight - drawImg.height) / 2;
      this.drawImg = drawImg;

      this.putToolBox();
    },
    // 将选择的图片绘制到画布
    putImgToCanv(e) {
      let file;

      if (e.target.files) {
        file = e.target.files[0] || null;
      } else {
        // 如果是IE9及以下
        console.error('IE9及以下需要自己传入image对象');
        // this.$emit('importImage',e);
        return false;
      }
      if (file) {
        let reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = (result) => {
          // 图片base64化
          let newUrl = result.target.result;

          let img = document.createElement('img');

          img.src = newUrl;
          let timmer = setInterval(() => {
            if (reader.readyState === 2) {
              clearInterval(timmer);
              if (
                !this.sizeChange &&
                this.smallToUpload &&
                img.width <= this.cutWidth &&
                img.height <= this.cutHeight
              ) {
                file.name = this.changeFileName(file.name, this.fileType);
                this.$emit('cutDown', {
                  filename: this.changeFileName(file.name, this.fileType),
                  id: this.currentImg.id,
                  file: file,
                });
                return;
              }
              let imgHeight = img.height;

              let imgWidth = img.width;

              let boxWidth = this.boxWidth;

              let boxHeight = this.boxHeight;

              let rate;

              let drawImg = {...this.drawImg};

              drawImg.img = img;
              this.scaleImg.rate = imgWidth / imgHeight; // 缩放时用到此参数
              if (imgHeight < boxHeight && imgWidth < boxWidth) {
                rate = 1;
                drawImg.x = (boxWidth - imgWidth) / 2;
                drawImg.y = (boxHeight - imgHeight) / 2;
              } else {
                if (imgWidth / imgHeight <= boxWidth / boxHeight) {
                  // 计算宽高比
                  rate = boxHeight / imgHeight;
                  drawImg.x = (boxWidth - imgWidth * rate) / 2;
                } else {
                  rate = boxWidth / imgWidth;
                  drawImg.y = (boxHeight - imgHeight * rate) / 2;
                }
              }
              drawImg.swidth = imgWidth;
              drawImg.sheight = imgHeight;
              drawImg.width = imgWidth * rate;
              drawImg.height = imgHeight * rate;
              drawImg.x = (boxWidth - drawImg.width) / 2;
              drawImg.y = (boxHeight - drawImg.height) / 2;
              // this.$set(this, 'drawImg', drawImg);
              this.drawImg = drawImg;
              this.printImg();
              this.putToolBox();
            }
          }, 200);
        };
        this.$emit('onChooseImg', file);
      }
    },
    putToolBox() {
      if (
        this.toolBox.width === this.boxWidth / 2 ||
        this.toolBox.height === this.boxHeight / 2 ||
        this.saveCutPosition === false
      ) {
        this.toolBox.width = this.cutWidth > this.boxWidth ? this.boxWidth : this.cutWidth;
        this.toolBox.height = this.cutHeight > this.boxHeight ? this.boxHeight : this.cutHeight;
      }
      if ((this.toolBox.x === 0 && this.toolBox.y === 0) || this.saveCutPosition === false) {
        this.toolBox.x = this.boxWidth / 2 - this.toolBox.width / 2;
        this.toolBox.y = this.boxHeight / 2 - this.toolBox.height / 2;
      }
      this.checkToolBoxOverflow().then(() => {
        this.printImg();
      });

      // this.drawControlBox(this.toolBox.width, this.toolBox.height, this.toolBox.x, this.toolBox.y);
    },
    // 判断裁剪框是否超出图片
    checkToolBoxOverflow() {
      return new Promise((resolve) => {
        if (!this.toolBoxOverflow) {
          // 如果裁剪框不能超出图片 则先判断图片尺寸
          // 如果图片尺寸长宽都超过裁剪框 不做处理
          // 如果图片尺寸小于裁剪框 将图片缩放至合适尺寸
          if (this.drawImg.width < this.toolBox.width || this.drawImg.height < this.toolBox.height) {
            const p = this.drawImg.width / this.drawImg.height;
            if (this.drawImg.width < this.toolBox.width) {
              this.drawImg.width = this.toolBox.width;
              this.drawImg.height = this.drawImg.width / p;
            }
            if (this.drawImg.height < this.toolBox.height) {
              this.drawImg.height = this.toolBox.height;
              this.drawImg.width = this.drawImg.height * p;
            }
            // 根据图片缩放重新调整位置
            this.drawImg.x = (this.boxWidth - this.drawImg.width) / 2;
            this.drawImg.y = (this.boxHeight - this.drawImg.height) / 2;
          }
          // 判断左右边界
          if (this.drawImg.x > this.toolBox.x) {
            this.drawImg.x = this.toolBox.x;
          }
          if (this.drawImg.x + this.drawImg.width < this.toolBox.x + this.toolBox.width) {
            this.drawImg.x = this.toolBox.x + this.toolBox.width - this.drawImg.width;
          }
          // 判断上下边界
          if (this.drawImg.y > this.toolBox.y) {
            this.drawImg.y = this.toolBox.y;
          }
          if (this.drawImg.y + this.drawImg.height < this.toolBox.y + this.toolBox.height) {
            this.drawImg.y = this.toolBox.y + this.toolBox.height - this.drawImg.height;
          }
        }
        resolve();
      });
    },
    isSupportFileApi() {
      if (
        window.File &&
        window.FileList &&
        window.FileReader &&
        window.Blob &&
        navigator.userAgent.indexOf('Edge') === -1 &&
        navigator.userAgent.indexOf('MSIE') === -1 &&
        navigator.userAgent.indexOf('Trident') === -1
      ) {
        return true;
      }
      return false;
    },
    //将图片转换为Base64
    dataURLtoFile(dataurl, filename) {
      let arr = dataurl.split(','),
        mime = arr[0].match(/:(.*?);/)[1],
        bstr = atob(arr[1]),
        n = bstr.length,
        u8arr = new Uint8Array(n);

      while (n--) {
        u8arr[n] = bstr.charCodeAt(n);
      }
      if (this.isSupportFileApi()) {
        let file = new File([u8arr], filename, {type: mime});

        return file;
      }
      return '不支持File对象';
    },
    drawControlBox(width, height, x, y) {
      // 裁剪框是否能够超出图片
      if (!this.toolBoxOverflow) {
        // 如果不允许超出图片范围 则也不允许反选
        if (width < 1) {
          width = 1;
        }
        if (height < 1) {
          height = 1;
        }
        if (width > this.drawImg.width) {
          width = this.drawImg.width;
        }
        if (height > this.drawImg.height) {
          height = this.drawImg.height;
        }
        if (x < this.drawImg.x) {
          x = this.drawImg.x;
        }
        if (y < this.drawImg.y) {
          y = this.drawImg.y;
        }

        if (x > this.drawImg.x + this.drawImg.width - width) {
          x = this.drawImg.x + this.drawImg.width - width;
        }
        if (y > this.drawImg.y + this.drawImg.height - height) {
          y = this.drawImg.y + this.drawImg.height - height;
        }
      }
      // 阻止超出裁剪控件边界
      if (width > this.boxWidth) {
        width = this.boxWidth;
      }
      if (height > this.boxHeight) {
        height = this.boxHeight;
      }
      if (x < 0) {
        x = 0;
      }
      if (y < 0) {
        y = 0;
      }
      let $toolBoxControl = this.$refs['toolBoxControl'];

      let c = this.$refs['canvasSelectBox'];

      let ctx = c.getContext('2d');

      ctx.fillStyle = this.selectBoxColor;
      ctx.clearRect(0, 0, c.width, c.height);
      ctx.fillRect(0, 0, c.width, c.height);

      let toolBoxControlWidth, toolBoxControlHeight;

      if (this.rate && this.rate !== '') {
        let p = this.rate.split(':')[0] / this.rate.split(':')[1];

        if (p >= 1) {
          toolBoxControlWidth = width;
          toolBoxControlHeight = width / p;
          if (toolBoxControlHeight + y > this.drawImg.y + this.drawImg.height) {
            toolBoxControlHeight = this.drawImg.y + this.drawImg.height - y;
            toolBoxControlWidth = toolBoxControlHeight * p;
          }
        } else {
          toolBoxControlWidth = height * p;
          toolBoxControlHeight = height;
        }
      } else {
        toolBoxControlWidth = width;
        toolBoxControlHeight = height;
      }
      this.toolBox.width = Math.abs(toolBoxControlWidth);
      this.toolBox.height = Math.abs(toolBoxControlHeight);

      $toolBoxControl.style.width = Math.abs(toolBoxControlWidth) + 'px';
      $toolBoxControl.style.height = Math.abs(toolBoxControlHeight) + 'px';

      this.toolBox.boxMove.moveTo.x = x;
      this.toolBox.boxMove.moveTo.y = y;
      if (toolBoxControlWidth < 0) {
        x = x + toolBoxControlWidth;
      }
      if (toolBoxControlHeight < 0) {
        y = y + toolBoxControlHeight;
      }

      if (x + this.toolBox.width > this.boxWidth) {
        x = this.boxWidth - this.toolBox.width;
      }
      if (x < 0) {
        x = 0;
      }
      if (y + this.toolBox.height > this.boxHeight) {
        y = this.boxHeight - this.toolBox.height;
      }
      if (y < 0) {
        y = 0;
      }

      this.toolBoxPosition.x = x;
      this.toolBoxPosition.y = y;

      $toolBoxControl.style.left = x + 'px';
      $toolBoxControl.style.top = y + 'px';

      ctx.clearRect(x, y, Math.abs(toolBoxControlWidth), Math.abs(toolBoxControlHeight));
      // if (this.onPrintImgTimmer) {
      //   clearTimeout(this.onPrintImgTimmer);
      // }
      // this.onPrintImgTimmer = setTimeout(() => {
      //   this.cropPicture(true);
      // }, 100);
    },
    // 重置工具栏
    resetToolBox() {
      if (this.toolBox.width < 0) {
        this.toolBox.boxMove.moveTo.x = this.toolBox.x - this.toolBox.width;
      }
      if (this.toolBox.height < 0) {
        this.toolBox.boxMove.moveTo.y = this.toolBox.y - this.toolBox.height;
      }
      this.toolBox.width = Math.abs(this.toolBox.width);
      this.toolBox.height = Math.abs(this.toolBox.height);
    },
    // 鼠标按下裁剪区域
    toolBoxMouseDown(e) {
      let $toolBox = this.$refs['toolBoxControl'];
      this.toolBox.x = parseInt($toolBox.style.left.split('px')[0]);
      this.toolBox.y = parseInt($toolBox.style.top.split('px')[0]);
      this.toolBox.disable = false;
      this.dropImg.active = false;
      this.toolBox.boxMove.start = {
        x: e.pageX,
        y: e.pageY,
      };
    },
    // 鼠标在裁剪区域移动
    toolBoxMouseMove(e) {
      if (this.dropImg.active) {
        this.dropImgMove(e);
      }
      this.toolBox.x = this.currentLeft;
      this.toolBox.y = this.currentTop;
      let x = this.toolBox.x;
      let y = this.toolBox.y;
      this.drawControlBox(this.toolBox.width, this.toolBox.height, x, y);
      if (this.toolBox.disable === false && this.moveAble === true) {
        let offsetX = e.pageX - this.toolBox.boxMove.start.x;

        let offsetY = e.pageY - this.toolBox.boxMove.start.y;

        let x = this.toolBox.x + offsetX;

        let y = this.toolBox.y + offsetY;

        this.drawControlBox(this.toolBox.width, this.toolBox.height, x, y);
      }
    },
    // 鼠标离开裁剪区域
    toolBoxMouseLeave() {
      this.toolBox.disable = true;
      if (this.onPrintImgTimmer) {
        clearTimeout(this.onPrintImgTimmer);
      }
      this.onPrintImgTimmer = setTimeout(() => {
        this.cropPicture(true);
      }, 100);
      this.resetToolBox();
    },
    // 鼠标在裁剪区域抬起
    toolBoxMouseUp() {
      this.currentTop = parseInt(this.toolBoxPosition.y);
      this.currentLeft = parseInt(this.toolBoxPosition.x);
      this.toolBox.x = parseInt(this.toolBoxPosition.x);
      this.toolBox.y = parseInt(this.toolBoxPosition.y);
      this.toolBox.disable = true;
      this.dropImg.active = false;
      this.resetToolBox();
    },

    // 绘制图片
    printImg() {
      if (this.drawImg.img) {
        let canv = this.$refs['canvas'];

        let ctx = canv.getContext('2d');
        ctx.fillStyle = '#fff';
        ctx.fillRect(0, 0, canv.width, canv.height);
        ctx.save();
        ctx.translate(this.drawImg.x + this.drawImg.width / 2, this.drawImg.y + this.drawImg.height / 2);
        ctx.rotate((this.rotateImg.angle * Math.PI) / 180);
        ctx.translate(
          -(this.drawImg.x + this.drawImg.width / 2),
          -(this.drawImg.y + this.drawImg.height / 2)
        );
        ctx.translate(this.drawImg.x, this.drawImg.y);
        ctx.scale(this.isFlipHorizontal ? -1 : 1, this.isFlipVertically ? -1 : 1);
        ctx.drawImage(
          this.drawImg.img,
          this.drawImg.sx,
          this.drawImg.sy,
          this.drawImg.swidth,
          this.drawImg.sheight,
          this.isFlipHorizontal ? -this.drawImg.width : 0,
          this.isFlipVertically ? -this.drawImg.height : 0,
          this.drawImg.width,
          this.drawImg.height
        );
        ctx.translate(-this.drawImg.x, this.drawImg.y);
        ctx.restore();
        let tempImg = new Image();
        tempImg.setAttribute('crossOrigin', 'anonymous') //关键
        if (this.crossOrigin === true) {
          tempImg.crossOrigin = this.crossOriginHeader;
        }
        tempImg.src = canv.toDataURL(`image/${this.fileType}`, this.quality);
        this.$emit('onPrintImg', {
          id: this.currentImg.id,
          fileName: this.currentImg.name,
          dataURL: tempImg.src,
        });
        if (this.onPrintImgTimmer) {
          clearTimeout(this.onPrintImgTimmer);
        }
        this.onPrintImgTimmer = setTimeout(() => {
          this.cropPicture(true);
        }, 100);
      }
    },
    // 点击画布
    dropImgOn(e) {
      if (this.toolBoxControlBoxFlag) {
        this.imgMove = false;
        this.dropImg.active = false;
        let $toolBoxControl = this.$refs.toolBoxControl;
        $toolBoxControl.style.left = e.offsetX + 'px';
        $toolBoxControl.style.top = e.offsetY + 'px';
        this.toolBox.width = 0;
        this.toolBox.height = 0;
        this.currentTop = e.offsetY;
        this.currentLeft = e.offsetX;
        this.drawControlBox(this.toolBox.width, this.toolBox.height, e.offsetX, e.offsetY);
        this.toolBoxMouseMove(e)
        this.controlBtnMouseDown(e, 'rightDown')
      } else {
        this.imgMove = true;
        this.dropImg.active = true;
      }
      if (this.imgMove === true) {
        this.dropImg.active = true;
        this.dropImg.params = {...this.drawImg};
        this.dropImg.pageX = e.pageX;
        this.dropImg.pageY = e.pageY;
      }

    },
    // 离开画布
    dropImgOff() {
      this.dropImg.active = false;
      if (this.onPrintImgTimmer) {
        clearTimeout(this.onPrintImgTimmer);
      }
      this.onPrintImgTimmer = setTimeout(() => {
        this.cropPicture(true);
      }, 100);
    },
    // 在画布移动
    dropImgMove(e) {
      if (this.dropImg.active && this.drawImg.img) {
        let drawImg = {...this.drawImg};
        drawImg.x = this.dropImg.params.x - (this.dropImg.pageX - e.pageX);
        drawImg.y = this.dropImg.params.y - (this.dropImg.pageY - e.pageY);
        // 裁剪框是否能够超出图片
        if (!this.toolBoxOverflow) {
          if (drawImg.x > this.toolBox.x) {
            drawImg.x = this.toolBox.x;
          }
          if (drawImg.x < this.toolBox.x + this.toolBox.width - drawImg.width) {
            drawImg.x = this.toolBox.x + this.toolBox.width - drawImg.width;
          }

          if (drawImg.y > this.toolBox.y) {
            drawImg.y = this.toolBox.y;
          }
          if (drawImg.y < this.toolBox.y + this.toolBox.height - drawImg.height) {
            drawImg.y = this.toolBox.y + this.toolBox.height - drawImg.height;
          }
        }
        // this.$set(this, 'drawImg', drawImg);
        this.drawImg = drawImg;
        this.printImg();
        e.stopPropagation();
      }
    },
    // 滑动鼠标滚轮
    scaleImgWheel(e) {
      if (this.drawImg.img && this.scaleAble === true) {
        let scale;

        // e是FF的事件。window.event是chrome/ie/opera的事件
        let ee = e || window.event;

        if (ee.wheelDelta) {
          //IE/Opera/Chrome
          scale = -(ee.wheelDelta / 40);
        } else if (ee.detail) {
          //Firefox
          scale = ee.detail;
        }
        let widthLimit = 50;
        this.drawImg.x =
          this.drawImg.width - scale * 9 > widthLimit ? this.drawImg.x + scale * 3 : this.drawImg.x;
        this.drawImg.y =
          this.drawImg.width - scale * 9 > widthLimit ? this.drawImg.y + scale * 3 : this.drawImg.y;
        this.drawImg.width =
          this.drawImg.width - scale * 9 > widthLimit ? this.drawImg.width - scale * 9 : widthLimit;
        this.drawImg.height = this.drawImg.width / this.scaleImg.rate;
        this.checkToolBoxOverflow().then(() => {
          this.printImg();
          if (this.onPrintImgTimmer) {
            clearTimeout(this.onPrintImgTimmer);
          }
          this.onPrintImgTimmer = setTimeout(() => {
            this.cropPicture(true);
          }, 100);
        });
      }
      // let scrollTop = this.$refs['mask'].scrollTop;
      // window.scrollTo(this.$refs['mask'].scrollLeft,scrollTop);
      e.preventDefault();
      e.returnValue = false;
      return false;
    },
    // 裁剪
    handleCut() {
      if (this.drawImg.img) {
        let c = this.$refs['canvasSelectBox'];
        let ctx = c.getContext('2d');
        ctx.fillStyle = this.selectBoxColor;
        ctx.clearRect(0, 0, c.width, c.height);
        ctx.fillRect(0, 0, c.width, c.height);
        this.toolBoxControlBoxFlag = true;
        let $toolBoxControl = this.$refs.toolBoxControl;
        $toolBoxControl.style.left = '-30px';
        $toolBoxControl.style.top = '-10px';
        $toolBoxControl.style.width = '0';
        $toolBoxControl.style.height = '0';
        this.currentTop = 0;
        this.currentLeft = 0;
      } else {
        this.$message({message: '暂无图片!', type: 'warning'});
      }

    },
    // 保存裁剪
    handleSaveCut() {
      this.toolBoxControlBoxFlag = false;
      let c = this.$refs['canvasSelectBox'];

      let ctx = c.getContext('2d');
      ctx.clearRect(0, 0, c.width, c.height);

      this.initialize();
      let $image = new Image();
      $image.setAttribute('crossOrigin', 'anonymous') //关键
      $image.name = this.currentImg.name;
      $image.id = this.currentImg.id;
      $image.style.position = 'fixed';
      $image.style.top = -5000 + 'px';
      $image.style.opacity = 0;
      $image.src = this.downloadImgSrc;
      // $image.src = c.toDataURL(`image/${this.fileType}`, this.quality);
      this.cutImageObj = $image;
      this.$nextTick(() => {
        this.importImgToCanv($image);
      });
      let $toolBoxControl = this.$refs.toolBoxControl;
      $toolBoxControl.style.left = '-30px';
      $toolBoxControl.style.top = '-10px';
      $toolBoxControl.style.width = '0';
      $toolBoxControl.style.height = '0';
      this.currentTop = 0;
      this.currentLeft = 0;
      document.body.appendChild($image);
    },
    // 取消裁剪
    handleCancelCut() {
      this.toolBoxControlBoxFlag = false;
      let c = this.$refs['canvasSelectBox'];
      let ctx = c.getContext('2d');
      ctx.clearRect(0, 0, c.width, c.height);
      let $toolBoxControl = this.$refs.toolBoxControl;
      $toolBoxControl.style.left = '-30px';
      $toolBoxControl.style.top = '-10px';
      $toolBoxControl.style.width = '0';
      $toolBoxControl.style.height = '0';
      this.currentTop = 0;
      this.currentLeft = 0;
    },
    // 改变大小
    handleScale(scale) {
      if (this.drawImg.img && this.scaleAble === true) {
        let widthLimit = 50;
        this.drawImg.x =
          this.drawImg.width - scale * 9 > widthLimit ? this.drawImg.x + scale * 3 : this.drawImg.x;
        this.drawImg.y =
          this.drawImg.width - scale * 9 > widthLimit ? this.drawImg.y + scale * 3 : this.drawImg.y;
        this.drawImg.width =
          this.drawImg.width - scale * 9 > widthLimit ? this.drawImg.width - scale * 9 : widthLimit;
        this.drawImg.height = this.drawImg.width / this.scaleImg.rate;
        this.checkToolBoxOverflow().then(() => {
          this.printImg();
          if (this.onPrintImgTimmer) {
            clearTimeout(this.onPrintImgTimmer);
          }
          this.onPrintImgTimmer = setTimeout(() => {
            this.cropPicture(true);
          }, 100);
        });
      } else {
        this.$message({message: '暂无图片!', type: 'warning'});
      }
    },
    // 左右翻转
    flipHorizontal() {
      if (this.drawImg.img) {
        if (this.isFlipHorizontal == false) {
          this.isFlipHorizontal = true;
        } else {
          this.isFlipHorizontal = false;
        }
        this.printImg();
      } else {
        this.$message({message: '暂无图片!', type: 'warning'});
      }
    },
    // 垂直翻转
    flipVertically() {
      if (this.drawImg.img) {
        if (this.isFlipVertically == false) {
          this.isFlipVertically = true;
        } else {
          this.isFlipVertically = false;
        }
        this.printImg();
      } else {
        this.$message({message: '暂无图片!', type: 'warning'});
      }
    },
    // 旋转
    turnImg(angle) {
      let startAngle = this.rotateImg.angle;

      let turnAngle = startAngle + angle;

      if (turnAngle >= -180 && turnAngle <= 180) {
        this.rotateImg.angle = turnAngle;
        this.rotateControl.position = (turnAngle / 180) * 100 + 100;
        this.printImg('rotate');
      }
    },
    // 还原
    turnReset() {
      this.initialize();
      if (this.drawImg.img) {
        let $image = new Image();
        $image.setAttribute('crossOrigin', 'anonymous') //关键
        $image.name = this.currentImg.name;
        $image.id = this.currentImg.id;
        $image.style.position = 'fixed';
        $image.style.top = -5000 + 'px';
        $image.style.opacity = 0;
        $image.src = this.currentImg.src;
        this.cutImageObj = $image;
        this.$nextTick(() => {
          this.importImgToCanv($image);
        });
        document.body.appendChild($image);
      } else {
        this.$message({message: '暂无图片!', type: 'warning'});
      }

    },
    // 上一页
    previousPage(val) {
      this.$emit('previousPage', val);
      this.initialize();
    },
    // 上一页
    nextPage(val) {
      this.$emit('nextPage', val);
      this.initialize();
    },
    // 上移
    imgMoveUp(val) {
      this.$emit('imgMoveUp', val);
      this.initialize();
    },
    // 下移
    imgMoveDown(val) {
      this.$emit('imgMoveDown', val);
      this.initialize();
    },
    // 选择图片,替换
    chooseImg(val) {
      this.$emit('chooseImg', val);
      this.$refs['inputFile'].click();
    },
    // 下一件
    handleNextPiece(val) {
      this.$emit('handleNextPiece', val);
      this.initialize();
    },

    // control box
    controlBtnMouseDown(e, btnName) {
      this.controlBox.disable = false;
      this.controlBox.btnName = btnName;
      this.controlBox.start.x = e.clientX;
      this.controlBox.start.y = e.clientY;
      this.controlBox.start.width = this.toolBox.width;
      this.controlBox.start.height = this.toolBox.height;
      e.stopPropagation();
    },
    controlBtnMouseUp(e) {
      this.controlBox.disable = true;
      this.dropImgOff();
      this.resetToolBox();
      this.toolBoxMouseUp();
      e.stopPropagation();
    },
    controlBtnMouseMove(e) {
      if (this.controlBox.disable === false) {
        let offsetX = e.clientX - this.controlBox.start.x;

        let offsetY = e.clientY - this.controlBox.start.y;

        let x, y;

        if (this.controlBox.btnName == 'leftUp') {
          if (!this.rate) {
            x = this.toolBox.x + offsetX;
            y = this.toolBox.y + offsetY;
          } else {
            let p = this.rate.split(':')[0] / this.rate.split(':')[1];

            if (p >= 1) {
              x = this.toolBox.x + offsetX;
              y = this.toolBox.y + offsetX / p;
            } else {
              x = this.toolBox.x + offsetY * p;
              y = this.toolBox.y + offsetY;
            }
          }
          this.toolBox.width = this.controlBox.start.width - offsetX;
          this.toolBox.height = this.controlBox.start.height - offsetY;
        }
        if (this.controlBox.btnName == 'rightUp') {
          if (!this.rate) {
            x = this.toolBox.x;
            y = this.toolBox.y + offsetY;
          } else {
            let p = this.rate.split(':')[0] / this.rate.split(':')[1];

            if (p >= 1) {
              x = this.toolBox.x;
              y = this.toolBox.y - offsetX / p;
            } else {
              x = this.toolBox.x;
              y = this.toolBox.y + offsetY;
            }
          }
          this.toolBox.width = this.controlBox.start.width + offsetX;
          this.toolBox.height = this.controlBox.start.height - offsetY;
        }
        if (this.controlBox.btnName == 'rightDown') {
          x = this.toolBox.x;
          y = this.toolBox.y;
          this.toolBox.width = this.controlBox.start.width + offsetX;
          this.toolBox.height = this.controlBox.start.height + offsetY;
        }
        if (this.controlBox.btnName == 'leftDown') {
          if (!this.rate) {
            x = this.toolBox.x + offsetX;
            y = this.toolBox.y;
          } else {
            let p = this.rate.split(':')[0] / this.rate.split(':')[1];

            if (p >= 1) {
              x = this.toolBox.x + offsetX;
              y = this.toolBox.y;
            } else {
              x = this.toolBox.x + -offsetY * p;
              y = this.toolBox.y;
            }
          }
          this.toolBox.width = this.controlBox.start.width - offsetX;
          this.toolBox.height = this.controlBox.start.height + offsetY;
        }
        if (this.controlBox.btnName == 'topCenter') {
          x = this.toolBox.x;
          y = this.toolBox.y + offsetY;
          this.toolBox.width = this.controlBox.start.width;
          this.toolBox.height = this.controlBox.start.height - offsetY;
        }
        if (this.controlBox.btnName == 'downCenter') {
          x = this.toolBox.x;
          y = this.toolBox.y;
          this.toolBox.width = this.controlBox.start.width;
          this.toolBox.height = this.controlBox.start.height + offsetY;
        }
        if (this.controlBox.btnName == 'leftCenter') {
          x = this.toolBox.x + offsetX;
          y = this.toolBox.y;
          this.toolBox.width = this.controlBox.start.width - offsetX;
          this.toolBox.height = this.controlBox.start.height;
        }
        if (this.controlBox.btnName == 'rightCenter') {
          x = this.toolBox.x;
          y = this.toolBox.y;
          this.toolBox.width = this.controlBox.start.width + offsetX;
          this.toolBox.height = this.controlBox.start.height;
        }
        this.drawControlBox(this.toolBox.width, this.toolBox.height, x, y);
      }
      e.stopPropagation();
    },
    changeFileName(fileName, type) {
      let index = fileName.lastIndexOf('.');
      return fileName.substr(0, index + 1) + (type === 'jpeg' ? 'jpg' : type);
    },
    cropPicture(doNotReset) {
      let _this = this;

      if (this.drawImg.img) {
        let canvas = this.$refs['canvas'];

        let tempImg = new Image();
        tempImg.setAttribute('crossOrigin', 'anonymous') //关键
        if (this.crossOrigin === true) {
          tempImg.crossOrigin = this.crossOriginHeader;
        }
        tempImg.src = canvas.toDataURL(`image/${this.fileType}`, _this.quality);
        if (!HTMLCanvasElement.prototype.toBlob) {
          Object.defineProperty(HTMLCanvasElement.prototype, 'toBlob', {
            value: (callback, type, quality) => {
              if (window.atob) {
                setTimeout(() => {
                  let binStr = atob(canvas.toDataURL(type, quality).split(',')[1]);
                  let len = binStr.length,
                    arr = new Uint8Array(len);
                  let NewBlob;
                  for (let i = 0; i < len; i++) {
                    arr[i] = binStr.charCodeAt(i);
                  }
                  try {
                    NewBlob = new Blob([arr], {
                      type: `image/${_this.fileType}`,
                    });
                  } catch (e) {
                    window.BlobBuilder =
                      window.BlobBuilder ||
                      window.WebKitBlobBuilder ||
                      window.MozBlobBuilder ||
                      window.MSBlobBuilder;
                    if (e.name == 'TypeError' && window.BlobBuilder) {
                      const BlobBuilder = window.BlobBuilder;

                      let bb = new BlobBuilder();

                      bb.append(arr.buffer);
                      NewBlob = bb.getBlob(`image/${_this.fileType}`);
                    }
                    if (e.name == 'InvalidStateError') {
                      NewBlob = new Blob([arr.buffer], {type: `image/${_this.fileType}`});
                    }
                  }
                  // TypeError old chrome and FF
                  callback(NewBlob);
                }, 200);
              } else {
                callback(false, {
                  type: `image/${_this.fileType}`,
                });
              }
            },
          });
        }
        canvas.toBlob((blob) => {
          if (blob) {
            let reader = new FileReader();
            reader.readAsDataURL(blob);
            reader.onload = () => {
              let timmer = setInterval(() => {
                if (reader.readyState == 2) {
                  clearInterval(timmer);
                  let newCanv = document.createElement('canvas');
                  let ctx = newCanv.getContext('2d');
                  // 原图裁剪 originalGraph
                  if (_this.originalGraph == true) {
                    let scale = _this.drawImg.width / _this.drawImg.swidth;

                    // 计算实际图像大小
                    let transWidth = _this.toolBox.width / scale;

                    let transHeight = _this.toolBox.height / scale;

                    newCanv.width = transWidth;
                    newCanv.height = transHeight;
                    // 重新计算裁剪坐标
                    let sx = (_this.toolBox.x - _this.drawImg.x) / scale;

                    let sy = (_this.toolBox.y - _this.drawImg.y) / scale;

                    let swidth = _this.drawImg.swidth;

                    let sheight = _this.drawImg.sheight;

                    // TODO 使原图裁剪支持旋转后的图像
                    // ctx.translate(sx + transWidth/2, sy + transHeight/2);
                    // ctx.rotate((_this.rotateImg.angle) * Math.PI / 180);
                    // ctx.translate(-(sx + transWidth/2), -(sy + transHeight/2));
                    ctx.translate(-sx, -sy);
                    ctx.drawImage(_this.drawImg.img, 0, 0, swidth, sheight);
                  } else {
                    newCanv.width = _this.toolBox.width;
                    newCanv.height = _this.toolBox.height;
                    let params = _this.toolBox;

                    if (_this.rate) {
                      let p = _this.rate.split(':')[0] / _this.rate.split(':')[1];

                      let m = _this.rate.split(':')[0];

                      let n = _this.rate.split(':')[1];

                      if (m >= n) {
                        ctx.drawImage(
                          tempImg,
                          params.x,
                          params.y,
                          params.width,
                          params.width * p,
                          0,
                          0,
                          params.width,
                          params.width * p
                        );
                      } else {
                        ctx.drawImage(
                          tempImg,
                          params.x,
                          params.y,
                          params.width,
                          params.width / p,
                          0,
                          0,
                          params.width,
                          params.width / p
                        );
                      }
                    } else {
                      ctx.drawImage(
                        tempImg,
                        params.x,
                        params.y,
                        params.width,
                        params.height,
                        0,
                        0,
                        params.width,
                        params.height
                      );
                    }
                  }
                  newCanv.toBlob(
                    (newBlob) => {
                      let fileName = _this.changeFileName(_this.fileName, _this.fileType);
                      if (!doNotReset) {
                        _this.$emit('cutDown', {
                          id: this.currentImg.id,
                          fileName,
                          blob: newBlob,
                          file: _this.dataURLtoFile(
                            newCanv.toDataURL(`image/${_this.fileType}`, _this.quality),
                            fileName
                          ),
                          dataURL: newCanv.toDataURL(
                            `image/${_this.fileType}`,
                            _this.quality
                          ),
                        });
                      } else {
                        if (_this.previewMode) {
                          _this.$emit('onPrintImg', {
                            id: this.currentImg.id,
                            fileName,
                            blob: newBlob,
                            file: _this.dataURLtoFile(
                              newCanv.toDataURL(
                                `image/${_this.fileType}`,
                                _this.quality
                              ),
                              fileName
                            ),
                            dataURL: newCanv.toDataURL(
                              `image/${_this.fileType}`,
                              _this.quality
                            ),
                          });

                        }
                      }
                    },
                    `image/${_this.fileType}`,
                    _this.quality
                  );
                }
              }, 200);
            };
          } else {
            // IE9及以下
            let newCanv = document.createElement('canvas');

            newCanv.width = _this.toolBox.width;
            newCanv.height = _this.toolBox.height;
            let ctx = newCanv.getContext('2d');

            let params = _this.toolBox;

            if (_this.rate) {
              let p = _this.rate.split(':')[0] / _this.rate.split(':')[1];

              ctx.drawImage(
                tempImg,
                params.x,
                params.y,
                params.width,
                params.width * p,
                0,
                0,
                params.width,
                params.width * p
              );
            } else {
              ctx.drawImage(
                tempImg,
                params.x,
                params.y,
                params.width,
                params.height,
                0,
                0,
                params.width,
                params.height
              );
            }
            let fileName = _this.changeFileName(_this.fileName, _this.fileType);
            // let fileName = _this.fileName;
            if (!doNotReset) {
              // _this.handleClose();
              _this.$emit('cutDown', {
                id: this.currentImg.id,
                fileName,
                dataURL: newCanv.toDataURL(`image/${_this.fileType}`, _this.quality),
              });
            } else {
              _this.$emit('onPrintImg', {
                id: this.currentImg.id,
                fileName,
                dataURL: newCanv.toDataURL(`image/${_this.fileType}`, _this.quality),
              });
            }

          }
        }),
          `image/${_this.fileType}`,
          _this.quality;
      } else {
        if (!doNotReset) {
          console.warn('No picture selected');
          _this.$emit('error', {
            err: 1,
            msg: 'No picture selected',
          });
        }
      }
    },
    // 保存图片
    savePicture() {
      let _this = this;

      if (this.drawImg.img) {
        let canvas = this.$refs['canvas'];
        canvas.toBlob((blob) => {
          if (blob) {
            let reader = new FileReader();
            reader.readAsDataURL(blob);
            reader.onload = () => {
              let timmer = setInterval(() => {
                if (reader.readyState == 2) {
                  clearInterval(timmer);
                  if (_this.toolBoxControlBoxFlag) {
                    this.handleSaveCut();
                    let fileName = _this.changeFileName(_this.fileName, _this.fileType);
                    _this.$emit('cutDown', {
                      id: this.currentImg.id,
                      fileName,
                      file: _this.dataURLtoFile(
                        this.downloadImgSrc,
                        fileName
                      ),
                      dataURL: this.downloadImgSrc,
                    });
                  } else {
                    let tempImg = new Image();
                    tempImg.setAttribute('crossOrigin', 'anonymous') //关键
                    if (this.crossOrigin === true) {
                      tempImg.crossOrigin = this.crossOriginHeader;
                    }
                    tempImg.src = canvas.toDataURL(`image/${this.fileType}`, _this.quality);
                    // let newCanv = canvas;
                    canvas.toBlob(
                      (newBlob) => {
                        let fileName = _this.changeFileName(_this.fileName, _this.fileType);
                        _this.$emit('cutDown', {
                          id: this.currentImg.id,
                          fileName,
                          blob: newBlob,
                          file: _this.dataURLtoFile(
                            tempImg.src,
                            fileName
                          ),
                          dataURL: tempImg.src,
                        });
                        _this.$emit('onPrintImg', {
                          id: this.currentImg.id,
                          fileName,
                          blob: newBlob,
                          file: _this.dataURLtoFile(
                            tempImg.src,
                            fileName
                          ),
                          dataURL: tempImg.src,
                        });

                      },
                      `image/${_this.fileType}`,
                      _this.quality
                    );

                  }

                }
              }, 200);
            };
          } else {
            // IE9及以下
            let newCanv = document.createElement('canvas');

            newCanv.width = _this.toolBox.width;
            newCanv.height = _this.toolBox.height;
            let ctx = newCanv.getContext('2d');

            let params = _this.toolBox;

            if (_this.rate) {
              let p = _this.rate.split(':')[0] / _this.rate.split(':')[1];

              ctx.drawImage(
                tempImg,
                params.x,
                params.y,
                params.width,
                params.width * p,
                0,
                0,
                params.width,
                params.width * p
              );
            } else {
              ctx.drawImage(
                tempImg,
                params.x,
                params.y,
                params.width,
                params.height,
                0,
                0,
                params.width,
                params.height
              );
            }
            let fileName = _this.changeFileName(_this.fileName, _this.fileType);
            _this.$emit('cutDown', {
              id: this.currentImg.id,
              fileName,
              dataURL: newCanv.toDataURL(`image/${_this.fileType}`, _this.quality),
            });
            _this.$emit('onPrintImg', {
              id: this.currentImg.id,
              fileName,
              dataURL: newCanv.toDataURL(`image/${_this.fileType}`, _this.quality),
            });
          }

        }),
          `image/${_this.fileType}`,
          _this.quality;
      } else {
        console.log('no img')
      }
    },

    scrollBarControlMove(e) {
      if (this.rotateControl.active) {
        let offsetX = e.pageX - this.rotateControl.start.x;

        //                let rotate = this.rotateImg.angle/360*100 + offsetX/100*100;
        let position = this.rotateControl.start.position + offsetX;

        if (position <= 0) {
          position = 0;
        }
        if (position >= 200) {
          position = 200;
        }
        this.rotateControl.position = position;
        this.rotateImg.angle = ((position - 100) / 100) * 180;
        this.printImg();
      }
    },
    scrollBarControlOn(e) {
      this.rotateControl.active = true;
      this.rotateControl.start.x = e.pageX;
      this.rotateControl.start.y = e.pageY;
      this.rotateControl.start.position = this.rotateControl.position;
    },
    scrollBarControlOff() {
      this.rotateControl.active = false;
    },
  },
  watch: {
    currentImg(newValue, oldValue) {
      this.$nextTick(() => {
        this.initialize();
        this.handleOpen(newValue);
      })
    },
  },

};
</script>
<style lang="scss" scoped>
.vue-img-cutter {
  font-size: 12px;
}

.fr {
  float: right;
}

.mask {
  background: rgba(0, 0, 0, 0.6);
  position: fixed;
  overflow-y: scroll;
  overflow-x: hidden;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 1000;
  display: flex;
  justify-content: center;
  align-items: center;
}

.dialogMainModal {
  font-size: 16px;
  border: 1px solid rgba(0, 0, 0, 0.8);
  width: 90%;
  height: 90%;
  background: #fff;
  z-index: 1000;
  border-radius: 8px;
  overflow: hidden;
  position: relative;

  .toolMain {
    .tool-title {
      height: 50px;
      background-color: rgba(204, 204, 204, 0.18);
      padding: 10px 20px;
      box-sizing: border-box;
      font-size: 20px;
      display: flex;
      justify-content: space-between;
      align-items: center;

      .close {
        width: 24px;
        height: 24px;
        font-size: 18px;
      }

    }

    .tool-des {
      padding-left: 20px;
      box-sizing: border-box;
      height: 40px;
      line-height: 40px;

      .des {
        color: red !important;
      }
    }

    .toolBox {
      border: 1px solid #dedede;
      box-sizing: border-box;
      width: 75%;
      height: calc(90vh - 245px);
      overflow: auto;
      //background-color: #fff;
      //background-image: linear-gradient(
      //    45deg,
      //    rgba(0, 0, 0, 0.25) 25%,
      //    transparent 0,
      //    transparent 75%,
      //    rgba(0, 0, 0, 0.25) 0
      //),
      //linear-gradient(45deg, rgba(0, 0, 0, 0.25) 25%, transparent 0, transparent 75%, rgba(0, 0, 0, 0.25) 0);
      //background-color: #eee;
      background-size: 30px 30px;
      background-position: 0 0, 15px 15px;
      position: relative;
    }
  }
}


.canvas {
  position: absolute;
  top: 0;
  left: 0;
  z-index: 98;
  margin: 20px 10px;

}

.noImg {
  //background-color: red;
  height: 100%;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}

.i-dialog-footer {
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  padding-right: 20px;
  height: 60px;
  background-color: rgba(204, 204, 204, 0.18);
  display: flex;
  justify-content: flex-end;
  align-items: center;

}

.canvasSelectBox {
  position: absolute;
  top: 0;
  left: 0;
  z-index: 99;
  margin: 20px 10px;

}

@keyframes zi-antBorder {
  0% {
    background-position: 0px 0px;
  }
  50% {
    background-position: 0px 5px;
  }
  100% {
    background-position: 0px 10px;
  }
}

.toolBoxControl {
  background: rgba(255, 255, 255, 0);
  position: absolute;
  z-index: 101;
  box-sizing: border-box;
  width: 0;
  height: 0;
  margin: 20px 10px;
  display: none;
  left: -40px;
}

.isToolBoxControl {
  display: block;
}

.toolBoxControlBox {
  width: 100%;
  height: 100%;
  position: relative;
  background: transparent;
  z-index: 103;
  pointer-events: none;
}

.controlBoxInnerLine {
  position: absolute;
  z-index: 1;
  background-size: 10px 10px;
  background-image: linear-gradient(
      -45deg,
      rgba(64, 158, 255, 1) 25%,
      rgba(64, 158, 255, 0) 25%,
      rgba(64, 158, 255, 0) 50%,
      rgba(64, 158, 255, 1) 50%,
      rgba(64, 158, 255, 1) 75%,
      rgba(64, 158, 255, 0) 75%,
      rgba(64, 158, 255, 0)
  );
  -ms-animation: zi-antBorder 0.8s linear 0s infinite normal;
  -moz-animation: zi-antBorder 0.8s linear 0s infinite normal;
  -webkit-animation: zi-antBorder 0.8s linear 0s infinite normal;
  animation: zi-antBorder 0.8s linear 0s infinite normal;
  pointer-events: none;
}

.controlBoxInnerLineTop {
  height: 1px;
  width: 100%;
  top: -1px;
}

.controlBoxInnerLineBottom {
  height: 1px;
  width: 100%;
  bottom: -1px;
}

.controlBoxInnerLineLeft {
  height: 100%;
  width: 1px;
  left: -1px;
  top: 0;
}

.controlBoxInnerLineRight {
  height: 100%;
  width: 1px;
  right: -1px;
  top: 0;
}

.toolBoxControlLine {
  position: absolute;
  z-index: 1;
  background: transparent;
}

.toolBoxControlLineItem-1 {
  top: 33%;
  width: 100%;
  height: 1px;
  box-sizing: border-box;
  border-bottom: 1px dashed #409eff;
}

.toolBoxControlLineItem-2 {
  top: 66%;
  width: 100%;
  height: 1px;
  box-sizing: border-box;
  border-bottom: 1px dashed #409eff;
}

.toolBoxControlLineItem-3 {
  left: 33%;
  border-right: 1px dashed #409eff;
  height: 100%;
  width: 1px;
  box-sizing: border-box;
}

.toolBoxControlLineItem-4 {
  left: 66%;
  border-right: 1px dashed #409eff;
  height: 100%;
  width: 1px;
  box-sizing: border-box;
}

.controlBox {
  width: 100%;
  height: 100%;
  position: absolute;
  cursor: move;
  z-index: 1;
  pointer-events: none;
}

.controlBtn {
  border: 1px solid rgba(255, 255, 255, 0.5);
  box-sizing: border-box;
  width: 6px;
  height: 6px;
  background: #409eff;
  position: absolute;
  border-radius: 50%;
  z-index: 999;
  pointer-events: auto !important;
}

.leftUp {
  top: 0;
  left: 0;
  margin-left: -3px;
  margin-top: -3px;
  cursor: se-resize;
}

.leftDown {
  bottom: 0;
  left: 0;
  margin-left: -3px;
  margin-bottom: -3px;
  cursor: sw-resize;
}

.rightUp {
  top: 0;
  right: 0;
  margin-right: -3px;
  margin-top: -3px;
  cursor: sw-resize;
}

.rightDown {
  bottom: 0;
  right: 0;
  margin-right: -3px;
  margin-bottom: -3px;
  cursor: se-resize;
}

.topCenter {
  top: 0;
  right: 50%;
  margin-right: -3px;
  margin-top: -3px;
  cursor: s-resize;
}

.downCenter {
  bottom: 0;
  right: 50%;
  margin-right: -3px;
  margin-bottom: -3px;
  cursor: s-resize;
}

.leftCenter {
  top: 50%;
  left: 0;
  margin-left: -3px;
  margin-top: -3px;
  cursor: e-resize;
}

.rightCenter {
  top: 50%;
  right: 0;
  margin-right: -3px;
  margin-top: -3px;
  cursor: e-resize;
}

.rightDiv {
  width: calc(25% - 30px);
  height: 400px;
  background-color: #fff;
  //margin:10px 0 0 10px;
  margin-left: 10px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  & > div {
    height: calc(100% - 30px);
    width: 100%;
    border: 1px solid #E5E5E5;
    background: #E5E5E5;
    display: flex;
    justify-content: center;
    align-items: center;

    img {
      border: 1px solid #E5E5E5;
      height: calc(100% - 20px);
      width: calc(100% - 20px);
      object-fit: cover;
    }
  }

  p {
    color: #3A71A8;
  }
}

.selectArea {
  display: block;
  text-align: right;
  padding: 2px 10px;
  border-radius: 8px;
  background-color: #fff;
  color: #3A71A8;
  position: absolute;
  top: -24px;
  right: 0;
  font-size: 10px;
  user-select: none;
  min-width: 160px;

}

.selectBtn {
  display: block;
  padding: 0 10px;
  text-align: right;
  color: #3A71A8;
  position: absolute;
  bottom: 0;
  right: 0;
  font-size: 20px;

  & > div:first-of-type {
    margin-right: 20px;
  }
}

/*工具栏*/
.dockMain {
  box-sizing: border-box;
  padding: 5px 20px;
  border-radius: 5px;
  margin-top: 15px;
  background-color: #fff;
}

.dockMain:hover {
  opacity: 1;
}

.dockBtn {
  font-size: 10px;
  cursor: pointer;
  display: inline-block;
  margin-right: 4px;
  color: #409eff;
  border: 1px solid #c6e2ff;
  background-color: #ecf5ff;
  padding: 1px 4px;
  border-radius: 3px;
  height: 20px;
  line-height: 16px;
  transition: background 0.2s, color 0.2s;
  -webkit-touch-callout: none; /* iOS Safari */
  -webkit-user-select: none; /* Chrome/Safari/Opera */
  -khtml-user-select: none; /* Konqueror */
  -moz-user-select: none; /* Firefox */
  -ms-user-select: none; /* Internet Explorer/Edge */
  user-select: none; /* Non-prefixed version, currently*/
}

.dockBtn:hover {
  color: #fff;
  background-color: #409eff;
  border-color: #409eff;
}

/* 旋转进度条 */
.dockBtnScrollBar {
  display: inline-block;
  margin-right: 4px;
  margin-left: 10px;
  background: #409eff;
  width: 200px;
  height: 10px;
  border-radius: 5px;
  position: relative;
  -webkit-touch-callout: none; /* iOS Safari */
  -webkit-user-select: none; /* Chrome/Safari/Opera */
  -khtml-user-select: none; /* Konqueror */
  -moz-user-select: none; /* Firefox */
  -ms-user-select: none; /* Internet Explorer/Edge */
  user-select: none; /* Non-prefixed version, currently*/
}

.scrollBarControl {
  position: absolute;
  cursor: pointer;
  background: #fff;
  border: 2px solid #409eff;
  box-sizing: border-box;
  border-radius: 50%;
  width: 20px;
  height: 20px;
  top: 50%;
  transform: translate(-50%, -50%);
  box-shadow: 0 0 3px #1f5184;
}

.scrollBarText {
  position: absolute;
  cursor: pointer;
  background: rgba(0, 0, 0, 0.7);
  color: #fff;
  top: -16px;
  height: 16px;
  line-height: 16px;
  text-align: center;
  font-size: 10px;
  white-space: nowrap;
  min-width: 50px;
  border-radius: 3px;
  transform: translate(-50%, -50%);
}
</style>
