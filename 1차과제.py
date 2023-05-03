import tensorflow as tf
from tensorflow.python.keras.models import Sequential
from tensorflow.python.keras.layers import Dense, Activation

x_data = [[1,3],[2,1],[1,2],[4,5],[5,6],[7,7]]
y_data = [[0],[0],[0],[1],[1],[1]]

model = Sequential([Dense(units = 1, input_dim = 2),
                    Activation('sigmoid')
                    ])

model.compile(loss='binary_crossentropy',optimizer='adam',
              metrics=['accuracy'])

model.fit(x_data,y_data,epochs=1000, batch_size=1, verbose=1)

y_predict = model.predict([[0,1]])
print("First predict: {0}".format(y_predict))

y_predict = model.predict([[7,7]])
print("Second predict: {0}".format(y_predict))



