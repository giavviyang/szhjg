<!--
<template>
  <div class="boardBox">
    &lt;!&ndash; 绘图组件容器DOM &ndash;&gt;
    <div id="tui-image-editor"></div>
  </div>
</template>
<script>
import 'tui-image-editor/dist/tui-image-editor.css'
import 'tui-color-picker/dist/tui-color-picker.css'
const ImageEditor = require('tui-image-editor')
// 中文菜单
const localeCN = {
  Load: '替换图片',
  Download: '下载图片',
  ZoomIn: '放大',
  ZoomOut: '缩小',
  Hand: '手掌',
  History: '历史',
  Resize: '调整宽高',
  Crop: '裁剪',
  DeleteAll: '全部删除',
  Delete: '删除',
  Undo: '撤销',
  Redo: '反撤销',
  Reset: '重置',
  Flip: '镜像',
  Rotate: '旋转',
  Draw: '画',
  Shape: '形状标注',
  Icon: '图标标注',
  Text: '文字标注',
  Mask: '遮罩',
  Filter: '滤镜',
  Bold: '加粗',
  Italic: '斜体',
  Underline: '下划线',
  Left: '左对齐',
  Center: '居中',
  Right: '右对齐',
  Color: '颜色',
  'Text size': '字体大小',
  Custom: '自定义',
  Square: '正方形',
  Apply: '应用',
  Cancel: '取消',
  'Flip X': 'X 轴',
  'Flip Y': 'Y 轴',
  Range: '区间',
  Stroke: '描边',
  Fill: '填充',
  Circle: '圆',
  Triangle: '三角',
  Rectangle: '矩形',
  Free: '曲线',
  Straight: '直线',
  Arrow: '箭头',
  'Arrow-2': '箭头2',
  'Arrow-3': '箭头3',
  'Star-1': '星星1',
  'Star-2': '星星2',
  Polygon: '多边形',
  Location: '定位',
  Heart: '心形',
  Bubble: '气泡',
  'Custom icon': '自定义图标',
  'Load Mask Image': '加载蒙层图片',
  Grayscale: '灰度',
  Blur: '模糊',
  Sharpen: '锐化',
  Emboss: '浮雕',
  'Remove White': '除去白色',
  Distance: '距离',
  Brightness: '亮度',
  Noise: '噪音',
  'Color Filter': '彩色滤镜',
  Sepia: '棕色',
  Sepia2: '棕色2',
  Invert: '负片',
  Pixelate: '像素化',
  Threshold: '阈值',
  Tint: '色调',
  Multiply: '正片叠底',
  Blend: '混合色',
  Width: '宽度',
  Height: '高度',
  'Lock Aspect Ratio': '锁定宽高比例'
}
// 画布组件自定义样式
const customTheme = {
  // image 坐上角度图片
  'common.bi.image': '', // 在这里换上你喜欢的logo图片
  'common.bisize.width': '0px',
  'common.bisize.height': '0px',
  'common.backgroundImage': 'none',
  'common.backgroundColor': '#f3f4f6',
  'common.border': '1px solid #444',

  // header
  'header.backgroundImage': 'none',
  'header.backgroundColor': '#f3f4f6',
  'header.border': '0px',

  // load button
  'loadButton.backgroundColor': '#fff',
  'loadButton.border': '1px solid #ddd',
  'loadButton.color': '#222',
  'loadButton.fontFamily': 'NotoSans, sans-serif',
  'loadButton.fontSize': '12px',
  'loadButton.display': 'none', // 可以直接隐藏掉

  // download button
  'downloadButton.backgroundColor': '#fdba3b',
  'downloadButton.border': '1px solid #fdba3b',
  'downloadButton.color': '#fff',
  'downloadButton.fontFamily': 'NotoSans, sans-serif',
  'downloadButton.fontSize': '12px',
  'downloadButton.display': 'none', // 可以直接隐藏掉

  // icons default
  'menu.normalIcon.color': '#8a8a8a',
  'menu.activeIcon.color': '#555555',
  'menu.disabledIcon.color': '#434343',
  'menu.hoverIcon.color': '#e9e9e9',
  'submenu.normalIcon.color': '#8a8a8a',
  'submenu.activeIcon.color': '#e9e9e9',

  'menu.iconSize.width': '24px',
  'menu.iconSize.height': '24px',
  'submenu.iconSize.width': '32px',
  'submenu.iconSize.height': '32px',

  // submenu primary color
  'submenu.backgroundColor': '#1e1e1e',
  'submenu.partition.color': '#858585',

  // submenu labels
  'submenu.normalLabel.color': '#858585',
  'submenu.normalLabel.fontWeight': 'lighter',
  'submenu.activeLabel.color': '#fff',
  'submenu.activeLabel.fontWeight': 'lighter',

  // checkbox style
  'checkbox.border': '1px solid #ccc',
  'checkbox.backgroundColor': '#fff',

  // rango style
  'range.pointer.color': '#fff',
  'range.bar.color': '#666',
  'range.subbar.color': '#d1d1d1',

  'range.disabledPointer.color': '#414141',
  'range.disabledBar.color': '#282828',
  'range.disabledSubbar.color': '#414141',

  'range.value.color': '#fff',
  'range.value.fontWeight': 'lighter',
  'range.value.fontSize': '11px',
  'range.value.border': '1px solid #353535',
  'range.value.backgroundColor': '#151515',
  'range.title.color': '#fff',
  'range.title.fontWeight': 'lighter',

  // colorpicker style
  'colorpicker.button.border': '1px solid #1e1e1e',
  'colorpicker.title.color': '#fff'
}
export default {
  name: 'imageEditor',
//   name: 'imgBrief',
  props: {
    imgUrl: {
      type: String,
      default () {
        return ''
      }
    }
  },
  data () {
    return {
      // 创建的画布对象
      instance: null
    }
  },
  // 页面创建完成后调用
  mounted () {
    // console.log(document.documentElement.clientWidth)
    // console.log(document.documentElement.clientHeight)
    // ? 获取到当前屏幕的宽高，用于判断当前是大屏幕还是小屏幕==》进而确定的那个要渲染哪个init（画布大小不一样）
    // ? 如果不压缩图片大小，太大的图片出现拖动，手机端无法操作，所以要根据不同屏幕大小渲染不同大小的画布
    if (document.documentElement.clientWidth <= 500) {
      this.initMini()
    } else {
      // 页面加载好，就调用这个方法来创建图片编辑器
      this.init()
    }
  },
  // TODO：监听页面宽高变化，动态修改画布宽高，自适应图片
  methods: {
    // 创建图片编辑器 ==>大屏幕
    init () {
      // 创建tui-image-editor组件实例，后续操作需要用到this.instance这个对象
      this.instance = new ImageEditor(
        document.querySelector('#tui-image-editor'),
        {
          includeUI: {
            // 默认加载的图片
            loadImage: {
              // 图片路径
              //   path: sessionStorage.getItem('base64Url'),
              path: 'https://p1-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/c1d7a1feb60346449c1a64893888989a~tplv-k3u1fbpfcp-watermark.image',
              // path: imgUrl,
              // 图片的名字，可以省略
              name: 'image'
            },
            // 默认开启绘图的功能,小屏幕情况下，直接打开菜单，会占用较大屏幕空间，不美观
            initMenu: 'resize',
            // 支持的菜单
            menu: ['resize', 'crop', 'rotate',], // 底部菜单按钮列表 隐藏镜像flip和遮罩mask
            // 菜单位置在下面
            menuBarPosition: 'bottom',
            // 汉化
            locale: localeCN,
            // 自定义样式（隐藏默认顶部栏目、按钮颜色。。。）
            theme: customTheme
          },
          // 设置画布的最大宽高，能自动等比例缩放大图片到指定的宽高内
          // TODO：可以监听当前页面的缩放，动态修改画布最大宽高以防止图片过大
          cssMaxWidth: 850,
          cssMaxHeight: 580
        }
      )
      // 清除自定义样式造成的一条边框线
      document.getElementsByClassName('tui-image-editor-main')[0].style.top = 45
      // 设置图片编辑其余距离底部90px（就不会被底部展开的工具栏遮挡住了）===>无效
      document.getElementsByClassName('tui-image-editor-wrap')[0].style.bottom = 90

      //! 修改图片编辑器的顶部导航栏
      // 这个获取到的是tui-image-editor组件默认自带的顶部菜单栏目
      // console.log('顶部工具栏dom')
      // console.log(document.querySelector('.tui-image-editor-help-menu'))
      // 将顶部菜单栏整个隐藏掉
      // document.querySelector('.tui-image-editor-help-menu').style.display = 'none'

      // 你也可以指定那个菜单隐藏，留几个有用的菜单
      // document.querySelector('[tooltip-content="Undo"]').style.display = 'none'// 上一步
      // document.querySelector('[tooltip-content="Redo"]').style.display = 'none' // 下一步
      // document.querySelector('[tooltip-content="Reset"]').style.display = 'none' // 完全重新编辑
      // document.querySelector('[tooltip-content="ZoomIn"]').style.display = 'none' // 放大
      // document.querySelector('[tooltip-content="ZoomOut"]').style.display = 'none' // 缩小
      // document.querySelector('[tooltip-content="Hand"]').style.display = 'none' // 拖动界面
      // document.querySelector('[tooltip-content="History"]').style.display = 'none'
      // document.querySelector('[tooltip-content="Delete"]').style.display = 'none' // 删除选中编辑内容
      // document.querySelector('[tooltip-content="DeleteAll"]').style.display = 'none' // 清空
      // 隐藏分割线
      // document.querySelectorAll('.tui-image-editor-icpartition').forEach(item => {
      //   item.style.display = 'none'
      // })
      // document.getElementsByClassName('tui-image-editor-main')[0].style.top = '45px' // 调整图片显示位置
      document.getElementsByClassName(
        'tie-btn-hand tui-image-editor-item help enabled'
      )[0].style.display = 'none' // 隐藏顶部手掌按钮
      document.getElementsByClassName(
        'tie-btn-delete tui-image-editor-item help'
      )[0].style.display = 'none' // 隐藏顶部删除按钮
    },
    // 创建图片编辑器 ==>小屏幕
    initMini () {
      // 创建tui-image-editor组件实例，后续操作需要用到this.instance这个对象
      this.instance = new ImageEditor(
        document.querySelector('#tui-image-editor'),
        {
          includeUI: {
            // 默认加载的图片
            loadImage: {
              // 图片路径
              //   path: sessionStorage.getItem('base64Url'),
              path: 'https://p1-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/c1d7a1feb60346449c1a64893888989a~tplv-k3u1fbpfcp-watermark.image',
              // 图片的名字，可以省略
              name: 'image'
            },
            // 默认开启绘图的功能,小屏幕情况下，直接打开菜单，会占用较大屏幕空间，不美观
            initMenu: 'draw',
            // 支持的菜单
            menu: [
              'crop', // 裁切
              'draw', // 添加绘画
              'text' // 添加文本
            ],
            // 菜单位置在下面
            menuBarPosition: 'bottom',
            // 汉化
            locale: localeCN,
            // 自定义样式（隐藏默认顶部栏目、按钮颜色。。。）
            theme: customTheme
          },
          // 设置画布的最大宽高，能自动等比例缩放大图片到指定的宽高内
          // !设置小图宽高，自动压缩图片，防止过大出现滚动，导致无法操作
          cssMaxWidth: 350,
          cssMaxHeight: 500
        }
      )
      // 清除自定义样式造成的一条边框线
      document.getElementsByClassName('tui-image-editor-main')[0].style.top = 0
      // 设置图片编辑其余距离底部90px（就不会被底部展开的工具栏遮挡住了）===>无效
      // document.getElementsByClassName('tui-image-editor-wrap')[0].style.bottom = 90

      //! 修改图片编辑器的顶部导航栏
      document.querySelector('[tooltip-content="History"]').style.display = 'none'
      // document.querySelector('[tooltip-content="Undo"]').style.display = 'none'// 上一步
      document.querySelector('[tooltip-content="Redo"]').style.display = 'none' // 下一步
      document.querySelector('[tooltip-content="Reset"]').style.display = 'none' // 完全重新编辑
      document.querySelector('[tooltip-content="Delete"]').style.display = 'none'
      document.querySelector('[tooltip-content="DeleteAll"]').style.display = 'none'
      // 隐藏分割线
      document.querySelectorAll('.tui-image-editor-icpartition').forEach(item => {
        item.style.display = 'none'
      })
    },
    // 对图片插入左下角用户名和日期文字===》当点击保存按钮时触发
    addUserNameText (base64String) {
      const fileUrl = this.dataURLtoFile(base64String)
      // ?new Date().getTime()==>获取当前时间戳，并通过changeDate方法转换成好看的格式，存在data中，方便绘制图片的时候印上去
      const drawADate = this.changeDate(new Date().getTime())
      // console.log('转化base64为文件类型：==》', fileUrl)
      //! tui-image-editor组件的官方方法，用于获取当前图片的宽高
      this.instance.loadImageFromFile(fileUrl).then(result => {
        // TODO：改成获取userName
        this.instance.addText('张三' + drawADate, {
          styles: {
            fill: '#2196F3',
            fontSize: 22,
            fontWeight: 'bold'
          },
          position: {
            x: 10,
            y: result.newHeight - 30
          }
        }).then(objectProps => {
          console.log('左下角文字加上了',objectProps)
        })
      })
    },
    /** 保存编辑后图片 */
    handleCanvas2Img () {
      // 调用组件官方方法，获取整个编辑后图片的base64数据
      const base64String = this.instance.toDataURL()
      // 给图片左下角插入文字（传入当前获取到的编辑后的图片base64数据）
      this.addUserNameText(base64String)
      // 要延时调用，否则会被锁死，因为异步方法会在没有这个dom时触发它
      setTimeout(() => {
        //! 将编辑后的base64图片码传给上传组件（父组件）
        // ?this.instance.toDataURL()==》重新调用组件官方方法，获取加入左下角文字后的base64数据
        sessionStorage.setItem('editedPicBase64', this.instance.toDataURL())
      }, 700)
    },
    // 将base64转换成file类型，用于给tui-image-editor组件的官方方法调用，计算获得当前图片的宽高
    // ? this.instance.loadImageFromFile这个官方的方法会返回图片的宽高，但是传入的必须时file类型的文件
    dataURLtoFile (dataurl) {
      var arr = dataurl.split(',')
      var mime = arr[0].match(/:(.*?);/)[1]
      var bstr = atob(arr[1])
      var n = bstr.length
      var u8arr = new Uint8Array(n)
      while (n&#45;&#45;) {
        u8arr[n] = bstr.charCodeAt(n)
      }
      return new File([u8arr], { type: mime })
    },
    // 转换时间格式
    changeDate (originVal) {
      const dt = new Date(originVal)
      // 年
      const y = dt.getFullYear()
      // dt.getMonth() + 1 就是获取日期+1变成1-12月，
      // ! 通过.padStart(2, '0')，当字符串长度不足两位时，用'0'来填充在首位至2位
      // ! 因为是针对字符串的，所以在dt.getMonth() + 1 + '' 转为字符串
      // 月
      const m = (dt.getMonth() + 1 + '').padStart(2, '0')
      // 日
      const d = (dt.getDate() + '').padStart(2, '0')
      // 时
      const hh = (dt.getHours() + '').padStart(2, '0')
      // 分
      const mm = (dt.getMinutes() + '').padStart(2, '0')
      // 秒
      const ss = (dt.getSeconds() + '').padStart(2, '0')
      // 返回过滤后的时间格式  yyyy-mm-dd hh:mm:ss
      return `${y}-${m}-${d} ${hh}:${mm}:${ss}`
    }
  }
}
</script>
<style lang="scss" scoped>
.boardBox {
  //   width: 100%;
  //   height: 80vh;
  height: 100%;
  width: 100%;
  background: #f9f9f9;
  //canvas {
  //  border: 1px solid #b3b3b3;
  //}
}

 .tui-image-editor-main-container {
  border: 1px solid #ddd !important;
}

 .tui-image-editor-help-menu.top {
  left: 35%;
}

.tui-image-editor-main {
  top: 52px !important;
}

</style>

-->
<template>
  <div class="image-view">
    <div class="container">
      <div ref="tui-image-editor" id="tui-image-editor"></div>
      <!--      <el-button class="save" type="primary" size="mini" @click="save">保存</el-button>-->
      <div class="save">
        <el-tooltip class="item" effect="dark" content="放大" placement="top-start">
          <el-button type="text" icon="el-icon-zoom-in" size="mini" @click="magnify" :disabled="imgUrl==''"/>
        </el-tooltip>
        <el-tooltip class="item" effect="dark" content="缩小" placement="top-start">
          <el-button type="text" icon="el-icon-zoom-out" size="mini" @click="shrink"
                     :disabled="imgUrl==''"/>
        </el-tooltip>
        <el-tooltip class="item" effect="dark" content="还原" placement="top-start">
          <el-button type="text" icon="el-icon-refresh" size="mini" @click="restore"/>
        </el-tooltip>
        <el-tooltip class="item" effect="dark" content="上一页" placement="top-start">
          <el-button type="text" icon="el-icon-arrow-left" size="mini" @click="previousPage()"/>
        </el-tooltip>
        <el-tooltip class="item" effect="dark" content="下一页" placement="top-start">
          <el-button type="text" icon="el-icon-arrow-right" size="mini" @click="nextPage()"></el-button>
        </el-tooltip>
        <el-tooltip class="item" effect="dark" content="上移" placement="top-start">
          <el-button type="text" icon="el-icon-top" size="mini">
          </el-button>
        </el-tooltip>
        <el-tooltip class="item" effect="dark" content="下移" placement="top-start">
          <el-button type="text" icon="el-icon-bottom" size="mini"/>
        </el-tooltip>
        <el-tooltip class="item" effect="dark" content="替换" placement="top-start">
          <el-button type="text" icon="el-icon-upload" size="mini"/>
        </el-tooltip>
        <el-tooltip class="item" effect="dark" content="下载" placement="top-start">
          <el-button type="text" icon="el-icon-download" size="mini"/>
        </el-tooltip>
        <el-tooltip class="item" effect="dark" content="加页" placement="top-start">
          <el-button type="text" icon="el-icon-plus" size="mini"/>
        </el-tooltip>
        <el-tooltip class="item" effect="dark" content="减页" placement="top-start">
          <el-button type="text" icon="el-icon-minus" size="mini"/>
        </el-tooltip>
        <el-tooltip class="item" effect="dark" content="撤销" placement="top-start">
          <el-button type="text" icon="el-icon-refresh-left" size="mini"/>
        </el-tooltip>
        <el-tooltip class="item" effect="dark" content="反撤销" placement="top-start">
          <el-button type="text" icon="el-icon-refresh-right" size="mini"/>
        </el-tooltip>
        <el-tooltip class="item" effect="dark" content="历史" placement="top-start">
          <el-button type="text" icon="el-icon-help" size="mini"/>
        </el-tooltip>
        <el-tooltip class="item" effect="dark" content="保存" placement="top-start">
          <el-button type="text" icon="el-icon-check" size="mini" @click="save"/>
        </el-tooltip>
      </div>
    </div>

  </div>
</template>
<script>
// import {
//   base64ToFile,
//   fileLocalDownLoad,
//   rafThrottle,
// } from "@/utils/file-util";

import "tui-image-editor/dist/tui-image-editor.css";
import "tui-color-picker/dist/tui-color-picker.css";
import ImageEditor from "tui-image-editor";

const locale_zh = {
  Load: '替换图片',
  Download: '下载图片',
  ZoomIn: "放大",
  ZoomOut: "缩小",
  Hand: "手掌",
  History: "历史",
  Resize: "调整宽高",
  Crop: "裁剪",
  DeleteAll: "全部删除",
  Delete: "删除",
  Undo: "撤销",
  Redo: "反撤销",
  Reset: "重置",
  Flip: "镜像",
  Rotate: "旋转",
  Draw: "画",
  Shape: "形状标注",
  Icon: "图标标注",
  Text: "文字标注",
  Mask: "遮罩",
  Filter: "滤镜",
  Bold: "加粗",
  Italic: "斜体",
  Underline: "下划线",
  Left: "左对齐",
  Center: "居中",
  Right: "右对齐",
  Color: "颜色",
  "Text size": "字体大小",
  Custom: "自定义",
  Square: "正方形",
  Apply: "应用",
  Cancel: "取消",
  "Flip X": "X 轴",
  "Flip Y": "Y 轴",
  Range: "区间",
  Stroke: "描边",
  Fill: "填充",
  Circle: "圆",
  Triangle: "三角",
  Rectangle: "矩形",
  Free: "曲线",
  Straight: "直线",
  Arrow: "箭头",
  "Arrow-2": "箭头2",
  "Arrow-3": "箭头3",
  "Star-1": "星星1",
  "Star-2": "星星2",
  Polygon: "多边形",
  Location: "定位",
  Heart: "心形",
  Bubble: "气泡",
  "Custom icon": "自定义图标",
  "Load Mask Image": "加载蒙层图片",
  Grayscale: "灰度",
  Blur: "模糊",
  Sharpen: "锐化",
  Emboss: "浮雕",
  "Remove White": "除去白色",
  Distance: "距离",
  Brightness: "亮度",
  Noise: "噪音",
  "Color Filter": "彩色滤镜",
  Sepia: "棕色",
  Sepia2: "棕色2",
  Invert: "负片",
  Pixelate: "像素化",
  Threshold: "阈值",
  Tint: "色调",
  Multiply: "正片叠底",
  Blend: "混合色",
  Width: "宽度",
  Height: "高度",
  "Lock Aspect Ratio": "锁定宽高比例",
};

const customTheme = {
  "common.bi.image": "", // 左上角logo图片
  "common.bisize.width": "0px",
  "common.bisize.height": "0px",
  "common.backgroundImage": "none",
  "common.backgroundColor": "#f3f4f6",
  "common.border": "1px solid #333",

  // header
  "header.backgroundImage": "none",
  "header.backgroundColor": "#f3f4f6",
  "header.border": "0px",
  "header.left": "0px",

  // load button
  "loadButton.backgroundColor": "#fff",
  "loadButton.border": "1px solid #ddd",
  "loadButton.color": "#222",
  "loadButton.fontFamily": "NotoSans, sans-serif",
  "loadButton.fontSize": "12px",
  "loadButton.display": "none", // 隐藏


  // download button
  "downloadButton.backgroundColor": "#fdba3b",
  "downloadButton.border": "1px solid #fdba3b",
  "downloadButton.color": "#fff",
  "downloadButton.fontFamily": "NotoSans, sans-serif",
  "downloadButton.fontSize": "12px",
  "downloadButton.display": "none", // 隐藏


  // icons default
  "menu.normalIcon.color": "#8a8a8a",
  "menu.activeIcon.color": "#555555",
  "menu.disabledIcon.color": "#ccc",
  "menu.hoverIcon.color": "#e9e9e9",
  "submenu.normalIcon.color": "#8a8a8a",
  "submenu.activeIcon.color": "#e9e9e9",
  "menu.iconSize.width": "24px",
  "menu.iconSize.height": "24px",
  "submenu.iconSize.width": "32px",
  "submenu.iconSize.height": "32px",


  // submenu primary color
  "submenu.backgroundColor": "#1e1e1e",
  "submenu.partition.color": "#858585",


  // submenu labels
  "submenu.normalLabel.color": "#858585",
  "submenu.normalLabel.fontWeight": "lighter",
  "submenu.activeLabel.color": "#fff",
  "submenu.activeLabel.fontWeight": "lighter",

  // checkbox style
  "checkbox.border": "1px solid #ccc",
  "checkbox.backgroundColor": "#fff",


  // rango style
  "range.pointer.color": "#fff",
  "range.bar.color": "#666",
  "range.subbar.color": "#d1d1d1",
  "range.disabledPointer.color": "#414141",
  "range.disabledBar.color": "#282828",
  "range.disabledSubbar.color": "#414141",
  "range.value.color": "#fff",
  "range.value.fontWeight": "lighter",
  "range.value.fontSize": "11px",
  "range.value.border": "1px solid #353535",
  "range.value.backgroundColor": "#151515",
  "range.title.color": "#fff",
  "range.title.fontWeight": "lighter",

  // colorpicker style
  "colorpicker.button.border": "1px solid #1e1e1e",
  "colorpicker.title.color": "#fff",

};

export default {
  name: "imageViewer",
  data() {
    return {
      instance: null,
      transform: {
        scale: 1,
        offsetX: 0,
        offsetY: 0,
      },
      flag: false,
      currentW: 1000,
      currentH: 600,
    };
  },
  props:{
    imgUrl:{
      type:String,
      default:"https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg"
    }
  },
  computed: {
    imageEditor() {
      return this.$refs["tui-image-editor"].querySelector(
        ".tui-image-editor-align-wrap"
      );
    },
    imgStyle() {
      return this.$refs["tui-image-editor"].querySelector(".tui-image-editor");
    },
  },
  watch: {
    instance: {
      //监听当前是否选中工具栏，如果选中图片不可进行拖拽
      // 不然就会导致如文字编辑图片跟随移动问题
      handler(newVal) {
        if (newVal.ui.submenu) {
          this.flag = true;
          //是否需要重置图片的放大缩小
          // this.transform.offsetX = 0
          // this.transform.offsetY = 0
          // this.imgStyle.style.marginLeft = `0px`
          // this.imgStyle.style.marginTop = `0px`
        } else {
          this.flag = false;
        }
      },
      deep: true,
    },
  },
  created() {
    this.$nextTick(async () => {
      await this.init();
      await this.deviceSupportInstall();
      document.addEventListener("mouseup", this.mouseup);
      this.keyDown();
    });
  },

  // 离开时销毁实例
  beforeDestroy() {
    document.removeEventListener("mouseup", this.mouseup);
    this.imageEditor.removeEventListener("mousewheel", this._mouseWheelHandler);
    this.imageEditor.removeEventListener("mousedown", this.mousedown);
    this._mouseWheelHandler = null;
    document.onkeydown=null;
  },
  methods: {
    //分件弹窗监听键盘回车保存事件
    keyDown() {
      let that = this
      //监听键盘按钮
      document.onkeydown = function (e) {
        if (e.keyCode === 37) {
          e.returnValue = false
          that.instance.rotate(-1);

        }
        if (e.keyCode === 39) {
          e.returnValue = false
          that.instance.rotate(1);
        }
        if (e.keyCode === 38) {
          e.returnValue = false
          // that.currentH =that.currentH + 50;
          // that.currentW =that.currentW + 50;
          that.instance.resize({
            width:  that.currentW ,
            height: that.currentH ,
          });
        }
        if (e.keyCode === 40) {
          e.returnValue = false
          // that.currentH =that.currentH - 50;
          // that.currentW =that.currentW - 50;
          // that.instance.resize({
          //   width:  that.currentW ,
          //   height: that.currentH ,
          // });
        }
      }
    },
    // 将文base64转文件对象
    base64ToFile(base64, fileName) {
      let arr = base64.split(',')
      let mime = arr[0].match(/:(.*?);/)[1]
      let bstr = atob(arr[1])
      let n = bstr.length
      let u8arr = new Uint8Array(n)
      while (n--) {
        u8arr[n] = bstr.charCodeAt(n)
      }
      let blob = new Blob([u8arr], {
        type: mime
      })
      blob.lastModifiedDate = new Date()
      blob.name = fileName
      // console.log('functionbase64ToFile -> blob', blob) // file
      return blob
    },

// 文件下载
    fileLocalDownLoad(blob, fileName) {
      let downloadElement = document.createElement('a')
      let href = window.URL.createObjectURL(blob)
      downloadElement.href = href
      downloadElement.download = decodeURIComponent(fileName)
      document.body.appendChild(downloadElement)
      downloadElement.click()
      document.body.removeChild(downloadElement)
      window.URL.revokeObjectURL(href)
    },

// 节流
    rafThrottle(fn) {
      let locked = false;
      return function (...args) {
        if (locked) return;
        locked = true;
        window.requestAnimationFrame(_ => {
          fn.apply(this, args);
          locked = false;
        });
      };
    },
    mouseup() {
      this.imageEditor.removeEventListener("mousemove", this._dragHandler);
    },
    deviceSupportInstall() {
      this._mouseWheelHandler = this.rafThrottle((e) => {
        const delta = e.wheelDelta ? e.wheelDelta : -e.detail;
        if (delta > 0) {
          this.handleActions("zoomIn", {
            zoomRate: 0.05,
          });
        } else {
          this.handleActions("zoomOut", {
            zoomRate: 0.05,
          });
        }
      });

      this.imageEditor.addEventListener("mousewheel", this._mouseWheelHandler);
      this.imageEditor.addEventListener("mousedown", this.mousedown);
    },
    mousedown(e) {
      if (e.button !== 0) return;
      const {offsetX, offsetY} = this.transform;
      const startX = e.pageX;
      const startY = e.pageY;
      this._dragHandler = (ev) => {
        if (this.flag) return;
        this.transform.offsetX = offsetX + ev.pageX - startX;
        this.transform.offsetY = offsetY + ev.pageY - startY;
        this.imgStyle.style.marginLeft = `${offsetX + ev.pageX - startX}px`;
        this.imgStyle.style.marginTop = `${offsetY + ev.pageY - startY}px`;
      };
      this.imageEditor.addEventListener("mousemove", this._dragHandler);
    },
    handleActions(action, options = {}) {
      const {zoomRate} = {
        zoomRate: 0.2,
        ...options,
      };
      const {transform} = this;
      switch (action) {
        case "zoomOut":
          if (transform.scale > 0.2) {
            transform.scale = parseFloat(
              (transform.scale - zoomRate).toFixed(3)
            );
          }
          break;
        case "zoomIn":
          transform.scale = parseFloat((transform.scale + zoomRate).toFixed(3));
          break;
      }
      const {scale} = this.transform;
      this.imgStyle.style.transform = `scale(${scale})`;
    },
    // 放大
    magnify(){
      this.handleActions("zoomIn", {
        zoomRate: 0.05,
      });
    },
    // 缩小
    shrink(){
      this.handleActions("zoomOut", {
        zoomRate: 0.05,
      });
    },
    // 还原
    restore(){
      this.transform= {
        scale: 1,
          offsetX: 0,
          offsetY: 0,
      };
      const {scale} = this.transform;
      this.imgStyle.style.transform = `scale(${scale})`;
      this.imgStyle.style.marginLeft = '0';
      this.imgStyle.style.marginTop = '0';
    },
    // 上一页
    previousPage(val){
      this.$emit('previousPage', val);
    },
    // 下一页
    nextPage(val){
      this.$emit('nextPage', val);
    },
    init() {
      this.instance = new ImageEditor(document.querySelector('#tui-image-editor'), {
        includeUI: {
          loadImage: {
            // path: "https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg",
            path: this.imgUrl,
            name: 'image'
          },
          menu: ['resize', 'crop', 'rotate',], // 底部菜单按钮列表 隐藏镜像flip和遮罩mask
          // initMenu: 'none', // 默认打开的菜单项
          menuBarPosition: 'bottom', // 菜单所在的位置
          locale: locale_zh, // 本地化语言为中文
          theme: customTheme // 自定义样式
        },
        cssMaxWidth: 1000, // canvas 最大宽度
        cssMaxHeight: 600 // canvas 最大高度
      })
      document.getElementsByClassName('tui-image-editor-main')[0].style.top = '45px' // 调整图片显示位置
      document.getElementsByClassName('tui-image-editor-help-menu top')[0].style.display = 'none' // 调整图片显示位置
      // document.getElementsByClassName('tui-image-editor-help-menu top')[0].style.left = '50px' // 调整图片显示位置
      document.getElementsByClassName('tie-btn-undo tui-image-editor-item help')[0].style.display = 'none' // 隐藏顶部撤销按钮
      document.getElementsByClassName('tie-btn-redo tui-image-editor-item help')[0].style.display = 'none' // 隐藏顶部反撤销按钮
      document.getElementsByClassName('tie-btn-hand tui-image-editor-item help enabled')[0].style.display = 'none' // 隐藏顶部手掌按钮
      document.getElementsByClassName('tie-btn-zoomIn tui-image-editor-item help enabled')[0].style.display = 'none' // 隐藏顶部放大按钮
      document.getElementsByClassName('tie-btn-zoomOut tui-image-editor-item help enabled')[0].style.display = 'none' // 隐藏顶部缩小按钮
      document.getElementsByClassName('tui-image-editor-icpartition')[0].style.display = 'none' // 隐藏顶部放大按钮
      document.getElementsByClassName('tui-image-editor-icpartition')[1].style.display = 'none' // 隐藏顶部放大按钮
      document.getElementsByClassName('tie-btn-history tui-image-editor-item help enabled')[0].style.display = 'none' // 隐藏顶部历史按钮
      document.getElementsByClassName('tie-btn-reset tui-image-editor-item help')[0].style.display = 'none' // 隐藏顶部重置按钮
      document.getElementsByClassName('tie-btn-delete tui-image-editor-item help')[0].style.display = 'none' // 隐藏顶部删除按钮
      document.getElementsByClassName('tie-btn-deleteAll tui-image-editor-item help')[0].style.display = 'none' // 隐藏顶部删除全部按钮
    },
    // 保存图片，并上传
    save() {
      const base64String = this.instance.toDataURL(); // base64 文件
      const data = window.atob(base64String.split(",")[1]);
      const ia = new Uint8Array(data.length);
      for (let i = 0; i < data.length; i++) {
        ia[i] = data.charCodeAt(i);
      }
      const blob = new Blob([ia], {type: "image/png"}); // blob 文件
      const form = new FormData();
      form.append("image", blob);
      // upload file
    },
  },
};
</script>

<style lang="scss" scoped>
.image-view {
  height: 100%;
  width: 100%;

  .container {
    height: 86vh;
    text-align: center;
    position: relative;

    .save {
      position: absolute;
      left: 10px;
      top:5px;
      height: 40px;
      .el-button{
        padding: 7px 8px 3px 8px;
        cursor: pointer;
        margin: 0 4px;
        font-size: 20px;color:#8A8A8A
      }
      .el-tooltip{
        color:#8A8A8A
      }
    }

    // 防止图片放大缩小时上下滚动
    > > > .tui-image-editor-wrap {
      overflow: hidden;
    }

    > > > .tui-image-editor-canvas-container {
      cursor: pointer;

    }

    > > > .tui-image-editor-container
    .tui-image-editor-submenu
    .tui-image-editor-submenu-item
    label
    > span {
      padding-top: 0;
    }
  }

  .bottom {
    display: flex;
    justify-content: flex-end;
    margin: 10px;
  }
}
</style>
