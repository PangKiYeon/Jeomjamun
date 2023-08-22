import base64
import os
import shutil
from flask import Flask, request
import keras
import tensorflow as tf
import numpy as np
import PIL.Image as Img
import googletrans
#실행시 각 컴퓨터에 맞게 경로 수정 필요

app = Flask(__name__)
class_names = ['a','b','c','d','e','f','g','h','i','j','k',
               'l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' ']
ulist = []
dir_path = "./crop"

def image_crop(img, save_path):
    (img_h, img_w) = img.size
    print(img.size)

    grid_w = 116
    grid_h = 116
    range_w = (int)(img_w / grid_w)
    range_h = (int)(img_h / grid_h)
    print(range_w, range_h)

    i = 0

    for w in range(range_w):
        for h in range(range_h):
            bbox = (h * grid_h, w * grid_w, (h + 1) * (grid_h), (w + 1) * (grid_w))
            print(h * grid_h, w * grid_w, (h + 1) * (grid_h), (w + 1) * (grid_w))
            crop_img = img.crop(bbox)

            fname = "{}.png".format("{0:05d}".format(i))
            savename = save_path + fname
            crop_img.save(savename)
            print('save file ' + savename + '....')
            i += 1

def changeimg(imgfile):
    img = Img.open(imgfile).convert('RGB')
    img = img.resize((30, 30))
    x = keras.utils.img_to_array(img)
    x = x.reshape((1,) + x.shape)
    return x

@app.route("/model",methods = ['POST'])

def model():
    if request.method == 'POST':
        base64Image = request.form.get('f')
        decoded_image = base64.b64decode(base64Image)
        img_path = os.path.join("./getimages/","uploaded_image.jpg")
        with open(img_path,"wb") as img_file:
            img_file.write(decoded_image)
        os.mkdir('./crop/')
        img = Img.open(img_path)
        image_crop(img, './crop/')
        file_list = os.listdir(dir_path)
        file_list.sort()
        model = tf.keras.models.load_model("C:/Users/BangAndroid/PycharmProjects/pythonProject/BrailleNet.h5")
        for hi in file_list:
            hu = changeimg("./crop/" + hi)
            pred = model.predict(hu)
            max = np.max(pred)
            index = np.where(pred == max)
            decoded = class_names[index[1][0]]
            ulist.append(decoded)
        text = (''.join(ulist))
        translator = googletrans.Translator()
        translation = translator.translate(text, dest='ko')
        transl = translation.text
        result = transl
        shutil.rmtree('./crop/')
        ulist.clear()

    return transl


if __name__ == "__main__":
    app.run(host = "0.0.0.0", port = "5000")







