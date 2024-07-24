import cv2
import numpy as np

# 读取图片
img = '/Users/moqi/Desktop/作业/大二下/Java/lab10_3/src/assets/6.png'

src = cv2.imread(img, cv2.IMREAD_COLOR)

# 转为灰度图像
gray = cv2.cvtColor(src, cv2.COLOR_BGR2GRAY)

# 使用Canny算法进行边缘检测
edges = cv2.Canny(gray, 50, 150)

# 寻找边缘
contours, _ = cv2.findContours(edges, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

# 找出最大的边界
max_contour = max(contours, key=cv2.contourArea)

# 创建一个和原图一样大小的全零图像（全黑）
mask = np.zeros_like(src)

# 画出最大的边界（用白色填充）
cv2.drawContours(mask, [max_contour], -1, (255, 255, 255), thickness=cv2.FILLED)

# 使用掩码来获取原图中的目标区域
result = cv2.bitwise_and(src, mask)

# 获取边界的尺寸
x, y, w, h = cv2.boundingRect(max_contour)

# 创建一个与边界一样大小的透明背景
background = np.zeros((h, w, 3), np.uint8)

# 将result中的非黑色部分（即图像部分）贴到background上
background = result[y:y+h, x:x+w]

# 保存结果
cv2.imwrite(img, background)