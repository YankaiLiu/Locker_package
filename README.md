# Tasking

* Given 还有空柜子， 包  When 存包  Then 存包成功，返回票据
* Given 没有空柜子，包  When 存包  Then 存包失败，不返回票据 ， 提示柜子已满
* Given 合法的票据   When 取包  Then  取包成功
* Given 不合法的票据 When 取包  Then 取包失败 提示不合法的票据
* Given 已经取过的票据 When 取包 Then 取包失败，提示已取包
