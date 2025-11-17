FROM python:3.11
COPY . /app
WORKDIR /app
RUN pip install -r requirements.txt
RUN adduser --disabled-password --gecos "" appuser
USER appuser
CMD ["python", "app.py"]
