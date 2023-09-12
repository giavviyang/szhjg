//xiaruibo 20230214 本js文件是自己创建的公共函数类，全局都可以调用，主要包括重名校验操作等。
import { chongMingCheck } from '@/api/szhjg/szhjgCommon'

//xiruibo 20230426 下面这个exports.在部署到生产环境时，登陆的时候会报错，貌似不支持exports.，所以暂时屏蔽掉吧。
// exports.install = function (Vue, options) {
//   Vue.prototype.chongMing = function (id,mc,type,entity){
//
//     chongMingCheck({id:id,mc:mc,type:type,entity:entity}).then(response => {
//       if (response.code == "200") {
//         this.$message({message: "名称重复，请重新输入", type: 'error'})
//       }else {
//         this.$message({message: "名称可用", type: 'success'});
//       }
//     });
//
//   };
// };
